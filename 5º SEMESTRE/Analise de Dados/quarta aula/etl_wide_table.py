import os
import warnings
import numpy as np
import pandas as pd

warnings.filterwarnings('ignore')

BASE_PATH   = "/content/drive/MyDrive/Colab Notebooks"
SILVER_PATH = f"{BASE_PATH}/Silver"
GOLD_PATH   = f"{BASE_PATH}/Gold"
os.makedirs(GOLD_PATH, exist_ok=True)

def achar_col(df, *palavras):
    for col in df.columns:
        cu = col.upper()
        if all(p.upper() in cu for p in palavras):
            return col
    return None

def haversine(lat1, lon1, lat2, lon2):
    """Calcula a distância em KM entre duas coordenadas."""
    R = 6371.0 
    lat1, lon1, lat2, lon2 = map(np.radians, [lat1, lon1, lat2, lon2])
    dlat = lat2 - lat1
    dlon = lon2 - lon1
    a = np.sin(dlat/2.0)**2 + np.cos(lat1) * np.cos(lat2) * np.sin(dlon/2.0)**2
    c = 2 * np.arcsin(np.sqrt(a))
    return R * c

def executar_etl():
    print("Iniciando ETL...")
    df_voos = pd.read_parquet(f"{SILVER_PATH}/voos_consolidado.parquet")
    df_aero = pd.read_parquet(f"{SILVER_PATH}/aeroportos.parquet")
    df_emp  = pd.read_parquet(f"{SILVER_PATH}/empresas_aereas.parquet")

    # Renomeia colunas Silver -> Padronizadas
    renomear = {}
    mapa = {
        'ICAOEmpresaAerea'       : achar_col(df_voos, 'ICAO', 'EMPRESA'),
        'NomeEmpresa'            : achar_col(df_voos, 'EMPRESA', 'AÉREA') or achar_col(df_voos, 'EMPRESA', 'AEREA'),
        'NumeroVoo'              : achar_col(df_voos, 'NÚMERO', 'VOO') or achar_col(df_voos, 'NUMERO', 'VOO'),
        'CodigoDI'               : achar_col(df_voos, 'DI'),
        'CodigoTipoLinha'        : achar_col(df_voos, 'TIPO', 'LINHA'),
        'ModeloEquipamento'      : achar_col(df_voos, 'MODELO'),
        'ICAOAerodromoOrigem'    : achar_col(df_voos, 'ICAO', 'ORIGEM'),
        'DescricaoOrigem'        : achar_col(df_voos, 'DESCRIÇÃO', 'ORIGEM') or achar_col(df_voos, 'DESCRICAO', 'ORIGEM'),
        'ICAOAerodromoDestino'   : achar_col(df_voos, 'ICAO', 'DESTINO'),
        'DescricaoDestino'       : achar_col(df_voos, 'DESCRIÇÃO', 'DESTINO') or achar_col(df_voos, 'DESCRICAO', 'DESTINO'),
        'PartidaPrevista'        : achar_col(df_voos, 'PARTIDA', 'PREVISTA'),
        'PartidaReal'            : achar_col(df_voos, 'PARTIDA', 'REAL'),
        'ChegadaPrevista'        : achar_col(df_voos, 'CHEGADA', 'PREVISTA'),
        'ChegadaReal'            : achar_col(df_voos, 'CHEGADA', 'REAL'),
        'SituacaoVoo'            : achar_col(df_voos, 'SITUAÇÃO', 'VOO') or achar_col(df_voos, 'SITUACAO', 'VOO'),
        'SituacaoPartida'        : achar_col(df_voos, 'SITUAÇÃO', 'PARTIDA') or achar_col(df_voos, 'SITUACAO', 'PARTIDA'),
        'SituacaoChegada'        : achar_col(df_voos, 'SITUAÇÃO', 'CHEGADA') or achar_col(df_voos, 'SITUACAO', 'CHEGADA'),
        'AssentosTotal'          : achar_col(df_voos, 'ASSENTO') if 'AssentosTotal' in df_voos.columns else None,
    }

    for novo, original in mapa.items():
        if original and original in df_voos.columns and original != novo:
            renomear[original] = novo
    df_voos.rename(columns=renomear, inplace=True)

    # Filtra APENAS Voos Regulares (N=Nacional, I=Internacional, R=Regional)
    if 'CodigoTipoLinha' in df_voos.columns:
        df_voos = df_voos[df_voos['CodigoTipoLinha'].isin(['N', 'I', 'R'])]

    for col_dt in ['PartidaPrevista','PartidaReal','ChegadaPrevista','ChegadaReal']:
        if col_dt in df_voos.columns:
            df_voos[col_dt] = pd.to_datetime(df_voos[col_dt], errors='coerce')

    if 'AssentosTotal' in df_voos.columns:
        df_voos.rename(columns={'AssentosTotal': 'AssentosDisponiveis'}, inplace=True)

    # Padroniza aeroportos
    ren_aero = {}
    for col in df_aero.columns:
        cu = col.upper()
        if ('ICAO' in cu or 'OACI' in cu) and 'ICAO' not in ren_aero.values():
            ren_aero[col] = 'ICAO'
        elif 'MUNIC' in cu and 'Municipio' not in ren_aero.values():
            ren_aero[col] = 'Municipio'
        elif (cu == 'UF' or 'ESTADO' in cu) and 'UF' not in ren_aero.values():
            ren_aero[col] = 'UF'
        elif 'NOME' in cu and 'AERO' in cu and 'NomeAeroporto' not in ren_aero.values():
            ren_aero[col] = 'NomeAeroporto'
        elif 'LATITU' in cu and 'Latitude' not in ren_aero.values():
            ren_aero[col] = 'Latitude'
        elif 'LONGITU' in cu and 'Longitude' not in ren_aero.values():
            ren_aero[col] = 'Longitude'
    df_aero.rename(columns=ren_aero, inplace=True)

    # Padroniza empresas
    ren_emp = {}
    for col in df_emp.columns:
        cu = col.upper()
        if ('ICAO' in cu or 'DESIGNA' in cu) and 'ICAO_Empresa' not in ren_emp.values():
            ren_emp[col] = 'ICAO_Empresa'
        elif 'NOME' in cu and 'NomeEmpresa' not in ren_emp.values():
            ren_emp[col] = 'NomeEmpresa'
    df_emp.rename(columns=ren_emp, inplace=True)

    # Construção da Wide Table
    wt = df_voos.copy()

    if 'PartidaPrevista' in wt.columns:
        wt['Data']         = wt['PartidaPrevista'].dt.date
        wt['Ano']          = wt['PartidaPrevista'].dt.year.astype('Int64')
        wt['Mes']          = wt['PartidaPrevista'].dt.month.astype('Int64')
        wt['MesNome']      = wt['PartidaPrevista'].dt.strftime('%b')
        wt['DiaSemana']    = wt['PartidaPrevista'].dt.day_name()
        wt['DiaSemanaNum'] = wt['PartidaPrevista'].dt.dayofweek
        hora               = wt['PartidaPrevista'].dt.hour
        wt['IntervaloHora']= pd.cut(hora, bins=[-1,5,11,17,23],
                                    labels=['Madrugada (00-05)','Manhã (06-11)',
                                            'Tarde (12-17)','Noite (18-23)'])

    if 'PartidaPrevista' in wt.columns and 'ChegadaPrevista' in wt.columns:
        wt['TempoVooEstimado_min'] = ((wt['ChegadaPrevista'] - wt['PartidaPrevista']).dt.total_seconds().div(60).round(1))
    if 'PartidaReal' in wt.columns and 'ChegadaReal' in wt.columns:
        wt['TempoVooReal_min'] = ((wt['ChegadaReal'] - wt['PartidaReal']).dt.total_seconds().div(60).round(1))

    if 'AtrasoPartida_min' not in wt.columns and 'PartidaReal' in wt.columns and 'PartidaPrevista' in wt.columns:
        wt['AtrasoPartida_min'] = ((wt['PartidaReal'] - wt['PartidaPrevista']).dt.total_seconds().div(60).round(1))
    if 'AtrasoChegada_min' not in wt.columns and 'ChegadaReal' in wt.columns and 'ChegadaPrevista' in wt.columns:
        wt['AtrasoChegada_min'] = ((wt['ChegadaReal'] - wt['ChegadaPrevista']).dt.total_seconds().div(60).round(1))

    def classificar_atraso(x):
        if pd.isna(x) or x <= 0:   return 'No Horário'
        elif x < 15:                return 'Atraso Leve (<15min)'
        elif x < 60:                return 'Atraso Moderado (15-60min)'
        else:                       return 'Atraso Severo (>60min)'

    if 'SituacaoPartida' not in wt.columns and 'AtrasoPartida_min' in wt.columns:
        wt['SituacaoPartida'] = wt['AtrasoPartida_min'].apply(classificar_atraso)
    if 'SituacaoChegada' not in wt.columns and 'AtrasoChegada_min' in wt.columns:
        wt['SituacaoChegada'] = wt['AtrasoChegada_min'].apply(classificar_atraso)

    if 'SituacaoVoo' in wt.columns:
        wt['VooRealizado'] = wt['SituacaoVoo'].astype(str).str.upper().str.contains('REALIZADO|REAL', na=False).astype(int)
    else:
        wt['VooRealizado'] = 1
    wt['QtdVoos'] = 1

    if 'NomeEmpresa' not in wt.columns:
        if 'ICAO_Empresa' in df_emp.columns and 'NomeEmpresa' in df_emp.columns:
            mapa_emp = df_emp.set_index('ICAO_Empresa')['NomeEmpresa'].to_dict()
            wt['NomeEmpresa'] = wt['ICAOEmpresaAerea'].map(mapa_emp).fillna(wt.get('ICAOEmpresaAerea', 'Desconhecida'))
        else:
            wt['NomeEmpresa'] = wt.get('ICAOEmpresaAerea', 'Desconhecida')

    cols_usar = [c for c in ['ICAO','Municipio','UF','NomeAeroporto','Latitude','Longitude'] if c in df_aero.columns]
    if len(cols_usar) > 1 and 'ICAO' in cols_usar:
        aero_idx = df_aero[cols_usar].drop_duplicates('ICAO').set_index('ICAO')
        extra = [c for c in cols_usar if c != 'ICAO']

        if 'ICAOAerodromoOrigem' in wt.columns:
            suf = {c: f'{c}Origem' for c in extra}
            wt = wt.merge(aero_idx[extra].rename(columns=suf), left_on='ICAOAerodromoOrigem', right_index=True, how='left')
        if 'ICAOAerodromoDestino' in wt.columns:
            suf = {c: f'{c}Destino' for c in extra}
            wt = wt.merge(aero_idx[extra].rename(columns=suf), left_on='ICAOAerodromoDestino', right_index=True, how='left')

    for par in [('Municipio','Cidade'), ('UF','UF')]:
        orig, dest = par
        for suf in ['Origem','Destino']:
            col_longa = f'{orig}{suf}'
            col_curta = f'{dest}{suf}'
            if col_longa in wt.columns and col_curta not in wt.columns:
                wt[col_curta] = wt[col_longa]

    if 'CidadeOrigem' in wt.columns and 'CidadeDestino' in wt.columns:
        wt['RotaCidade'] = (wt['CidadeOrigem'].fillna(wt['ICAOAerodromoOrigem']) + ' → ' + wt['CidadeDestino'].fillna(wt['ICAOAerodromoDestino']))

    if 'RotaNormalizada' not in wt.columns:
        if 'ICAOAerodromoOrigem' in wt.columns and 'ICAOAerodromoDestino' in wt.columns:
            wt['RotaNormalizada'] = wt.apply(lambda r: '-'.join(sorted([str(r['ICAOAerodromoOrigem']), str(r['ICAOAerodromoDestino'])])), axis=1)

    # Distância em KM usando Haversine
    if 'LatitudeOrigem' in wt.columns and 'LongitudeOrigem' in wt.columns and 'LatitudeDestino' in wt.columns and 'LongitudeDestino' in wt.columns:
        wt['DistanciaKM'] = haversine(wt['LatitudeOrigem'], wt['LongitudeOrigem'], wt['LatitudeDestino'], wt['LongitudeDestino'])

    if 'AssentosOcupados' not in wt.columns and 'TaxaOcupacao_pct' in wt.columns and 'AssentosDisponiveis' in wt.columns:
        wt['AssentosOcupados'] = (wt['AssentosDisponiveis'] * wt['TaxaOcupacao_pct'] / 100).round(0).astype('Int64')

    wt.to_parquet(f"{GOLD_PATH}/wide_table.parquet", index=False)
    wt.to_csv(f"{GOLD_PATH}/wide_table.csv", index=False)
    print("✔ Wide Table gerada com sucesso e salva na camada Gold!")

if __name__ == "__main__":
    executar_etl()