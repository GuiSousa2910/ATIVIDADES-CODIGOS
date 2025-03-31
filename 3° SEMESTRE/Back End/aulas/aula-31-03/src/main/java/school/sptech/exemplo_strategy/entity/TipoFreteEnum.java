package school.sptech.exemplo_strategy.entity;

public enum TipoFreteEnum {
    NORMAL("Entrega em até 12 dias úteis", 10.00, 0.1),
    EXPRESSO("Entrega em até 3 dias úteis", 30.00, 0.5),
    TRANSPORTADORA("Entrega em até 6 dias úteis", 20.00, 0.2);

    private final String descricao;
    private final Double valorFixo;
    private final Double acrescimo;

    TipoFreteEnum(String descricao, Double valorFixo, Double acrescimo) {
        this.descricao = descricao;
        this.valorFixo = valorFixo;
        this.acrescimo = acrescimo;
    }

    public String getDescricao() {
        return descricao;
    }
    public Double getValorFixo() {
        return valorFixo;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }
}