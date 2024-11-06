public enum Plano {

    BRONZE("Plano Bronze", 100.0),
    PRATA("Plano Prata", 200.0),
    OURO("Plano Ouro", 300.0);

    private final String descricao;
    private final Double valor;

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    Plano(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
