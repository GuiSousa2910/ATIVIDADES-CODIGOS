package school.sptech;

public class JogoTabuleiro extends Produto {

    private Integer qtdPecas;

    public JogoTabuleiro() {
    }

    public JogoTabuleiro(String nome, Integer qtdPecas, Raridade raridade) {
        super(nome, raridade);
        this.qtdPecas = qtdPecas;
    }

    public Integer getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(Integer qtdPecas) {
        this.qtdPecas = qtdPecas;
    }

    @Override
    public Double calcularPreco() {
        Double porcentagem = 0.0;
        switch (getRaridade()) {
            case COMUM:
                porcentagem = getRaridade().getAdicionalPorcentagem();
                porcentagem /= 100;
                break;
            case RARO:
                porcentagem = getRaridade().getAdicionalPorcentagem();
                porcentagem /= 100;
                break;
            case MUITO_RARO:
                porcentagem = getRaridade().getAdicionalPorcentagem();
                porcentagem /= 100;
                break;
        }
        return (getQtdPecas() * 0.5) + ((getQtdPecas() * 0.5) * porcentagem);
    }
}
