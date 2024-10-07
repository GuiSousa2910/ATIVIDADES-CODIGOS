package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private String titular;
    private String agencia;
    private String numero;
    private List<Operacao> operacoes;

    public ContaCorrente(String titular, String agencia, String numero) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.operacoes = new ArrayList<>();
    }

    public void adicionarOperacao(String categoria, String descricao, Double valor) {
        Operacao operacao1 = new Operacao(categoria, descricao, valor);
        if (categoria == null || categoria.equals(" ")) {

        } else {
            if (descricao == null || descricao.equals(" ")) {

            } else {
                if (valor != null && valor > 0.0) {
                    operacoes.add(operacao1);
                }
            }
        }

    }

    public List<Operacao> buscarOperacoesPorCategoria(String categoria) {
        List<Operacao> listaBusca = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            Operacao oV = operacoes.get(i);
            if (oV.getCategoria().equalsIgnoreCase(categoria)) {
                listaBusca.add(oV);
            }
        }
        return listaBusca;
    }

    public List<Operacao> buscarOperacoesPorValor(Double valor) {
        List<Operacao> listaBusca = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            Operacao oV = operacoes.get(i);
            if (oV.getValor().equals(valor)) {
                listaBusca.add(oV);
            }
        }
        return listaBusca;
    }


    public List<Operacao> buscarOperacoesSaida() {
        List<Operacao> listaBusca = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            Operacao oV = operacoes.get(i);
            if (oV.getValor() < 0.0) {
                listaBusca.add(oV);
            }
        }
        return listaBusca;
    }

    public List<Operacao> buscarOperacoesEntrada() {
        List<Operacao> listaBusca = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            Operacao oV = operacoes.get(i);
            if (oV.getValor() > 0.0) {
                listaBusca.add(oV);
            }
        }
        return listaBusca;
    }

    List<Operacao> buscarOperacoesPorDescricao(String descricao) {
        List<Operacao> operacaos = new ArrayList<>();

        if (descricao != null) {
            for (int i = 0; i < operacoes.size(); i++) {
                Operacao oV = operacoes.get(i);
                if (oV.getDescricao() != null && (oV.getDescricao().equalsIgnoreCase(descricao) || oV.getDescricao().toUpperCase().contains(descricao.toUpperCase()))) {
                    operacaos.add(oV);
                }
            }
        }
        return operacaos;
    }

    public Double buscarMaiorValor() {
        Double valorM = Double.NEGATIVE_INFINITY;
        if (!operacoes.isEmpty()) {
            for (int i = 0; i < operacoes.size(); i++) {
                Operacao oV = operacoes.get(i);
                if (oV.getValor() > valorM) {
                    valorM = oV.getValor();
                } else {

                }
            }
            return valorM;
        } else {
            return 0.0;
        }
    }

    public Double buscarMenorValor() {
        Double valorM = Double.POSITIVE_INFINITY;
        if (!operacoes.isEmpty()) {
            for (int i = 0; i < operacoes.size(); i++) {
                Operacao oV = operacoes.get(i);
                if (oV.getValor() < valorM) {
                    valorM = oV.getValor();
                } else {

                }
            }
            return valorM;
        } else {
            return 0.0;
        }
    }

    public Double obterSaldo() {
        Double soma = 0.0;
        if (!operacoes.isEmpty()) {
            for (int i = 0; i < operacoes.size(); i++) {
                Operacao oV = operacoes.get(i);
                soma += oV.getValor();
            }
            return soma;
        }else {
            return 0.0;
        }
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
