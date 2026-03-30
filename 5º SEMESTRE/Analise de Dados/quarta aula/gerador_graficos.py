import os
import warnings
import pandas as pd
import plotly.express as px
import plotly.graph_objects as go

warnings.filterwarnings('ignore')

BASE_PATH   = "/content/drive/MyDrive/Colab Notebooks"
GOLD_PATH   = f"{BASE_PATH}/Gold"
os.makedirs(GOLD_PATH, exist_ok=True)

CORES         = px.colors.qualitative.Bold
CORES_EMPRESA = px.colors.qualitative.Vivid
ORDEM_DIAS    = ['Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday']

def salvar(fig, nome):
    fig.show()
    try:
        fig.write_image(f"{GOLD_PATH}/{nome}.png", scale=2)
        print(f"  ✔ Salvo: Gold/{nome}.png")
    except Exception as e:
        print(f"  [PNG não salvo - verifique o pacote kaleido]: {e}")

def mes_label(ano, mes):
    import calendar
    return f"{calendar.month_abbr[int(mes)]}/{str(int(ano))[2:]}"

def ultimos_N_meses_2025(df, n):
    return sorted(df[df['Ano']==2025]['Mes'].dropna().unique())[-n:]

def filtrar_comparativo(df, meses):
    return df[((df['Ano']==2025) & (df['Mes'].isin(meses))) | ((df['Ano']==2024) & (df['Mes'].isin(meses)))].copy()

def top_n_col(df, grupo, metrica, n):
    return df.groupby(grupo)[metrica].sum().nlargest(n).index.tolist()

def gerar_graficos():
    print("Carregando Wide Table...")
    wt = pd.read_parquet(f"{GOLD_PATH}/wide_table.parquet")

    meses_3 = ultimos_N_meses_2025(wt, 3)
    wt_cmp  = filtrar_comparativo(wt, meses_3)

    # ================== BLOCO A ==================
    # A1
    if 'RotaCidade' in wt_cmp.columns:
        top10_r = top_n_col(wt_cmp, 'RotaCidade', 'QtdVoos', 10)
        df_a1 = (wt_cmp[wt_cmp['RotaCidade'].isin(top10_r)].assign(Periodo=lambda d: d.apply(lambda r: mes_label(r['Ano'], r['Mes']), axis=1)).groupby(['RotaCidade','Periodo','Ano']).agg(Previstos=('QtdVoos','count'), Realizados=('VooRealizado','sum')).reset_index().melt(id_vars=['RotaCidade','Periodo'], value_vars=['Previstos','Realizados'], var_name='Tipo', value_name='Voos'))

        fig_a1 = px.bar(df_a1, x='Periodo', y='Voos', color='Tipo', facet_col='RotaCidade', facet_col_wrap=2, barmode='group',
                        title='A1 – Voos Previstos x Realizados | Top 10 Rotas (Cidades)', color_discrete_sequence=['#1f77b4','#ff7f0e'], height=900)
        fig_a1.for_each_annotation(lambda a: a.update(text=a.text.split("=")[-1]))
        salvar(fig_a1, 'A1_previstos_realizados_top10_rotas')

    # A2
    if 'AssentosDisponiveis' in wt_cmp.columns and 'RotaCidade' in wt_cmp.columns:
        top10_ass = top_n_col(wt_cmp, 'RotaCidade', 'AssentosDisponiveis', 10)
        df_a2 = (wt_cmp[wt_cmp['RotaCidade'].isin(top10_ass)].assign(Periodo=lambda d: d.apply(lambda r: mes_label(r['Ano'], r['Mes']), axis=1)).groupby(['RotaCidade','Periodo']).agg(Disponiveis=('AssentosDisponiveis','sum'), Ocupados=('AssentosOcupados','sum')).reset_index().melt(id_vars=['RotaCidade','Periodo'], value_vars=['Disponiveis','Ocupados'], var_name='Tipo', value_name='Assentos'))

        fig_a2 = px.bar(df_a2, x='Periodo', y='Assentos', color='Tipo', facet_col='RotaCidade', facet_col_wrap=2, barmode='group',
                        title='A2 – Assentos Disponíveis x Ocupados | Top 10 Rotas (Cidades)', color_discrete_sequence=['#2ca02c','#d62728'], height=900)
        fig_a2.for_each_annotation(lambda a: a.update(text=a.text.split("=")[-1]))
        salvar(fig_a2, 'A2_assentos_disp_ocup_top10_rotas')

    # A3
    if 'AssentosDisponiveis' in wt_cmp.columns and 'RotaCidade' in wt_cmp.columns:
        top10_disp = top_n_col(wt_cmp[wt_cmp['Ano']==2025], 'RotaCidade', 'AssentosDisponiveis', 10)
        df_a3 = (wt_cmp[wt_cmp['RotaCidade'].isin(top10_disp)].assign(Periodo=lambda d: d.apply(lambda r: mes_label(r['Ano'], r['Mes']), axis=1)).groupby(['RotaCidade','Periodo','Ano']).agg(Disp=('AssentosDisponiveis','sum'), Ocup=('AssentosOcupados','sum')).reset_index())
        df_a3['TaxaOcupacao'] = (df_a3['Ocup'] / df_a3['Disp'] * 100).round(1)

        fig_a3 = px.bar(df_a3, x='RotaCidade', y='TaxaOcupacao', color=df_a3['Ano'].astype(str), barmode='group', facet_col='Periodo',
                        title='A3 – Taxa de Ocupação | Top 10 Rotas com Maior Disponibilidade', color_discrete_sequence=['#9467bd','#e377c2'], height=550)
        fig_a3.for_each_annotation(lambda a: a.update(text=a.text.split("=")[-1]))
        salvar(fig_a3, 'A3_taxa_ocupacao_top10_maior_disp')

    # A4
    if 'RotaCidade' in wt_cmp.columns and 'NomeEmpresa' in wt_cmp.columns:
        top5_r = top_n_col(wt_cmp, 'RotaCidade', 'QtdVoos', 5)
        linhas = []
        for rota in top5_r:
            df_r = wt_cmp[wt_cmp['RotaCidade'] == rota]
            top3e = top_n_col(df_r, 'NomeEmpresa', 'QtdVoos', 3)
            agg = df_r[df_r['NomeEmpresa'].isin(top3e)].groupby('NomeEmpresa')['QtdVoos'].sum().reset_index()
            agg['RotaCidade'] = rota
            linhas.append(agg)
        if linhas:
            df_a4 = pd.concat(linhas, ignore_index=True)
            fig_a4 = px.bar(df_a4, x='RotaCidade', y='QtdVoos', color='NomeEmpresa', barmode='stack',
                            title='A4 – Top 5 Rotas: Participação das Top 3 Empresas Aéreas', color_discrete_sequence=CORES_EMPRESA, height=480)
            salvar(fig_a4, 'A4_top5_rotas_top3_empresas')

    # A5
    if 'TaxaOcupacao_pct' in wt_cmp.columns and 'RotaCidade' in wt_cmp.columns:
        taxa_media = wt_cmp.groupby('RotaCidade')['TaxaOcupacao_pct'].mean()
        top10_ocup = taxa_media.nlargest(10).index.tolist()
        linhas5 = []
        for rota in top10_ocup:
            df_r = wt_cmp[wt_cmp['RotaCidade'] == rota]
            top3e = top_n_col(df_r, 'NomeEmpresa', 'QtdVoos', 3)
            agg = df_r[df_r['NomeEmpresa'].isin(top3e)].groupby('NomeEmpresa').agg(Voos=('QtdVoos','sum'), TaxaMedia=('TaxaOcupacao_pct','mean')).reset_index()
            agg['RotaCidade'] = rota
            linhas5.append(agg)
        if linhas5:
            df_a5 = pd.concat(linhas5, ignore_index=True)
            fig_a5 = px.bar(df_a5, x='RotaCidade', y='TaxaMedia', color='NomeEmpresa', barmode='group',
                            title='A5 – Top 10 Rotas com Maior Taxa de Ocupação | Top 3 Empresas', color_discrete_sequence=CORES, height=500)
            salvar(fig_a5, 'A5_top10_rotas_ocupacao_empresas')

    # ================== BLOCO B ==================
    # B1
    if 'AtrasoPartida_min' in wt.columns and 'ICAOAerodromoOrigem' in wt.columns:
        wt_b1 = filtrar_comparativo(wt, meses_3)
        df_b1 = (wt_b1.assign(ComAtraso=(wt_b1['AtrasoPartida_min'] > 0).astype(int)).groupby(['ICAOAerodromoOrigem','Ano']).agg(Total=('QtdVoos','count'), ComAtraso=('ComAtraso','sum')).reset_index())
        df_b1['PctAtraso'] = (df_b1['ComAtraso'] / df_b1['Total'] * 100).round(1)
        top10_at = df_b1[df_b1['Ano']==2025].nlargest(10,'PctAtraso')['ICAOAerodromoOrigem'].tolist()
        df_b1f = df_b1[df_b1['ICAOAerodromoOrigem'].isin(top10_at)]

        fig_b1 = px.bar(df_b1f, x='ICAOAerodromoOrigem', y='PctAtraso', color=df_b1f['Ano'].astype(str), barmode='group',
                        title='B1 – Top 10 Aeroportos | % Decolagens com Atraso (2024 vs 2025)', color_discrete_sequence=['#aec7e8','#1f77b4'], height=460)
        salvar(fig_b1, 'B1_top10_aero_atraso')

    # B2
    wt_t1 = wt[wt['Mes'].isin([1,2,3])].copy()
    if not wt_t1.empty:
        col_pass = 'AssentosOcupados' if 'AssentosOcupados' in wt_t1.columns else 'QtdVoos'
        dec = wt_t1.groupby(['ICAOAerodromoOrigem','Ano'])[col_pass].sum().reset_index().rename(columns={'ICAOAerodromoOrigem':'ICAO'})
        pou = wt_t1.groupby(['ICAOAerodromoDestino','Ano'])[col_pass].sum().reset_index().rename(columns={'ICAOAerodromoDestino':'ICAO'})
        mov = pd.concat([dec,pou]).groupby(['ICAO','Ano'])[col_pass].sum().reset_index().rename(columns={col_pass:'Valor'})
        top10_mv = top_n_col(mov[mov['Ano']==2025], 'ICAO', 'Valor', 10)
        df_b2 = mov[mov['ICAO'].isin(top10_mv)]

        fig_b2 = px.bar(df_b2, x='ICAO', y='Valor', color=df_b2['Ano'].astype(str), barmode='group',
                        title='B2 – Top 10 Aeroportos | Movimentação de Passageiros – 1º Trimestre', color_discrete_sequence=['#98df8a','#2ca02c'], height=460)
        salvar(fig_b2, 'B2_top10_aero_passageiros_trimestre')

    # B3
    if 'TempoVooEstimado_min' in wt.columns and 'TempoVooReal_min' in wt.columns:
        df_b3 = (wt.dropna(subset=['TempoVooEstimado_min','TempoVooReal_min']).assign(Variacao=lambda d: (d['TempoVooReal_min'] - d['TempoVooEstimado_min']).abs()).groupby('RotaNormalizada').agg(VariacaoMedia=('Variacao','mean'), TempoEstimado=('TempoVooEstimado_min','mean'), TempoReal=('TempoVooReal_min','mean')).nlargest(10,'VariacaoMedia').reset_index())

        fig_b3 = go.Figure([
            go.Bar(name='Tempo Estimado', x=df_b3['RotaNormalizada'], y=df_b3['TempoEstimado'].round(0), marker_color='#17becf'),
            go.Bar(name='Tempo Real', x=df_b3['RotaNormalizada'], y=df_b3['TempoReal'].round(0), marker_color='#e377c2'),
        ])
        fig_b3.update_layout(title='B3 – Top 10 Rotas | Maior Variação Tempo de Voo Previsto x Real', barmode='group', height=460)
        salvar(fig_b3, 'B3_top10_rotas_variacao_tempo')

    # B4
    if 'DistanciaKM' in wt.columns:
        df_b4 = (wt.groupby('RotaNormalizada').agg(DistanciaKM=('DistanciaKM','first'), Origem=('ICAOAerodromoOrigem','first'), Destino=('ICAOAerodromoDestino','first')).nlargest(10,'DistanciaKM').reset_index().sort_values('DistanciaKM', ascending=False))

        fig_b4 = go.Figure(data=[go.Table(
            header=dict(values=['Rota','Origem','Destino','Distância (KM)'], fill_color='#1f3a5f', font=dict(color='white')),
            cells=dict(values=[df_b4['RotaNormalizada'], df_b4['Origem'], df_b4['Destino'], df_b4['DistanciaKM'].round(0)], fill_color=[['#eef4fb','#ffffff']*10])
        )])
        fig_b4.update_layout(title='B4 – Top 10 Rotas Mais Distantes', height=420)
        salvar(fig_b4, 'B4_top10_rotas_distantes_board')

    # B5 (CORRIGIDO)
    if 'ICAOAerodromoOrigem' in wt.columns:
        dec5 = wt.groupby('ICAOAerodromoOrigem')['QtdVoos'].sum().rename('Decolagens')
        pou5 = wt.groupby('ICAOAerodromoDestino')['QtdVoos'].sum().rename('Pousos')
        
        # Concatena, calcula o total e organiza com colunas limpas
        df_b5 = pd.concat([dec5, pou5], axis=1).fillna(0)
        df_b5['Total'] = df_b5['Decolagens'] + df_b5['Pousos']
        df_b5 = df_b5.nlargest(10, 'Total').reset_index().rename(columns={'index': 'ICAO'})

        fig_b5 = go.Figure([
            go.Bar(name='Decolagens', x=df_b5['ICAO'], y=df_b5['Decolagens'], marker_color='#1f77b4'),
            go.Bar(name='Pousos', x=df_b5['ICAO'], y=df_b5['Pousos'], marker_color='#ff7f0e'),
        ])
        fig_b5.update_layout(title='B5 – Top 10 Aeroportos | Pousos e Decolagens', barmode='stack', height=460)
        salvar(fig_b5, 'B5_top10_aero_pousos_decolagens')

    # ================== BLOCO C ==================
    meses_2 = ultimos_N_meses_2025(wt, 2)
    wt_2m   = wt[(wt['Ano']==2025) & (wt['Mes'].isin(meses_2))].copy()

    # C1
    if 'ICAOAerodromoOrigem' in wt_2m.columns and 'IntervaloHora' in wt_2m.columns:
        top5_c1 = top_n_col(wt_2m, 'ICAOAerodromoOrigem', 'QtdVoos', 5)
        df_c1 = (wt_2m[wt_2m['ICAOAerodromoOrigem'].isin(top5_c1)].groupby(['ICAOAerodromoOrigem','DiaSemana','IntervaloHora'])['QtdVoos'].sum().reset_index())
        df_c1['DiaSemana'] = pd.Categorical(df_c1['DiaSemana'], categories=ORDEM_DIAS, ordered=True)
        df_c1 = df_c1.sort_values('DiaSemana')

        fig_c1 = px.bar(df_c1, x='DiaSemana', y='QtdVoos', color='IntervaloHora', facet_col='ICAOAerodromoOrigem',
                        title='C1 – Top 5 Aeroportos | Dia da Semana e Horário', color_discrete_sequence=CORES, height=500)
        salvar(fig_c1, 'C1_top5_aero_dia_horario')

    # C2
    if 'AssentosDisponiveis' in wt_2m.columns and 'RotaCidade' in wt_2m.columns:
        top10_c2 = top_n_col(wt_2m, 'RotaCidade', 'AssentosDisponiveis', 10)
        df_c2 = (wt_2m[wt_2m['RotaCidade'].isin(top10_c2)].groupby(['RotaCidade','DiaSemana','IntervaloHora'])['AssentosDisponiveis'].sum().reset_index())
        df_c2['DiaSemana'] = pd.Categorical(df_c2['DiaSemana'], categories=ORDEM_DIAS, ordered=True)
        df_c2 = df_c2.sort_values('DiaSemana')

        fig_c2 = px.bar(df_c2, x='DiaSemana', y='AssentosDisponiveis', color='IntervaloHora', facet_col='RotaCidade', facet_col_wrap=2,
                        title='C2 – Assentos Disponíveis | Dia, Horário e Top 10 Rotas', color_discrete_sequence=CORES, height=1100)
        salvar(fig_c2, 'C2_assentos_dia_hora_top10_rotas')

    # C3 (CORRIGIDO com Destino)
    if 'NomeEmpresa' in wt_2m.columns and 'CidadeOrigem' in wt_2m.columns and 'CidadeDestino' in wt_2m.columns:
        top3_global = top_n_col(wt_2m, 'NomeEmpresa', 'QtdVoos', 3)
        top5_cid    = top_n_col(wt_2m, 'CidadeOrigem', 'QtdVoos', 5)
        df_c3 = (wt_2m[(wt_2m['NomeEmpresa'].isin(top3_global)) & (wt_2m['CidadeOrigem'].isin(top5_cid)) & (wt_2m['VooRealizado']==1)].groupby(['CidadeOrigem','CidadeDestino','NomeEmpresa','DiaSemana','IntervaloHora'])['QtdVoos'].sum().reset_index())
        df_c3['DiaSemana'] = pd.Categorical(df_c3['DiaSemana'], categories=ORDEM_DIAS, ordered=True)
        df_c3 = df_c3.sort_values('DiaSemana')

        if not df_c3.empty:
            fig_c3 = px.bar(df_c3, x='DiaSemana', y='QtdVoos', color='NomeEmpresa', facet_col='CidadeOrigem', facet_col_wrap=3, barmode='group',
                            title='C3 – Voos Realizados | Top 3 Empresas × Cidade Origem e Destino', color_discrete_sequence=CORES_EMPRESA, height=700)
            salvar(fig_c3, 'C3_voos_top3_empresas_dia_hora')

    # C4
    if 'AssentosOcupados' in wt_2m.columns and 'CidadeDestino' in wt_2m.columns:
        df_c4 = (wt_2m.groupby('CidadeDestino')['AssentosOcupados'].sum().nlargest(10).reset_index().sort_values('AssentosOcupados'))
        fig_c4 = px.bar(df_c4, x='AssentosOcupados', y='CidadeDestino', orientation='h', color='AssentosOcupados', color_continuous_scale='Blues',
                        title='C4 – Top 10 Cidades Destino | Volume de Assentos Ocupados', height=460)
        salvar(fig_c4, 'C4_top10_cidades_destino_ocupados')

if __name__ == "__main__":
    gerar_graficos()