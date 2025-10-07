package school.sptech.lead.core.domain.lead;

public enum Enum {
    BAIXO("Nutrição mensal por e-mail", 4, 0.0, 100.0),
    MEDIO("Contato em até 72h + material educativo", 3),
    ALTO("Contato em até 48h + proposta personalizada", 2),
    VIP("Contato em até 24h + consultoria especializada", 1, 700.0, Double.MAX_VALUE);

    private final String sugestao;
    private final int prioridade;
    private final double minimoInclusivo;
    private final double maxInclusivo;

    Enum(String sugestao, int prioridade, double minimoInclusivo, double maxInclusivo) {
        this.sugestao = sugestao;
        this.prioridade = prioridade;
        this.minimoInclusivo = minimoInclusivo;
        this.maxInclusivo = maxInclusivo;
    }

    public boolean isInclusivo(Double consumo) {
        return consumo >= minimoInclusivo && consumo <= maxInclusivo;
    }



    public String getSugestao() {
        return sugestao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public enum Enum

    public Enum classificacao(Double consumo){
        if (consumo < 100) {
            return BAIXO;
        } else if (consumo < 300) {
            return MEDIO;
        } else if (consumo < 700) {
            return ALTO;
        } else {
            return VIP;
        }
    }
}
