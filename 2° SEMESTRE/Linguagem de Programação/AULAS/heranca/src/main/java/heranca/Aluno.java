package heranca;

public class Aluno {
    protected String nome;
    protected String ra;
    protected Double notaEntrega;
    protected Double notaPratica;
    protected Integer qntFaltas;

    public Aluno(String nome, String ra, Double notaEntrega, Double notaPratica, Integer qntFaltas) {
        this.nome = nome;
        this.ra = ra;
        this.notaEntrega = notaEntrega;
        this.notaPratica = notaPratica;
        this.qntFaltas = qntFaltas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Double getNotaEntrega() {
        return notaEntrega;
    }

    public void setNotaEntrega(Double notaEntrega) {
        this.notaEntrega = notaEntrega;
    }

    public Double getNotaPratica() {
        return notaPratica;
    }

    public void setNotaPratica(Double notaPratica) {
        this.notaPratica = notaPratica;
    }

    public Integer getQntFaltas() {
        return qntFaltas;
    }

    public void setQntFaltas(Integer qntFaltas) {
        this.qntFaltas = qntFaltas;
    }

    @Override
    public String toString() {
        return """
                RA: %s
                Nome: %s
                Nota Entrega: %.2f
                Nota Prática: %.2f
                Quantidade de Faltas: %d
                """.formatted(ra, nome, notaEntrega, notaPratica, qntFaltas);
    }

    public Double calcularMedia(){
        Double media = (notaEntrega + notaPratica) / 2.0;
        System.out.println("Media: " + media);
        return media;
    }

}
