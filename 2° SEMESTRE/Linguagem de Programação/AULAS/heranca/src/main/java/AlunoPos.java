public class AlunoPos extends Aluno {
    private Double notaTCC;
    private Double notaArtigo;

    public AlunoPos(String nome, String ra, Double notaEntrega, Double notaPratica,
                    Integer qntFaltas, Double notaTCC, Double notaArtigo) {
        super(nome, ra, notaEntrega, notaPratica, qntFaltas);
        this.notaTCC = notaTCC;
        this.notaArtigo = notaArtigo;
    }

    public Double getNotaArtigo() {
        return notaArtigo;
    }

    public void setNotaArtigo(Double notaArtigo) {
        this.notaArtigo = notaArtigo;
    }

    public Double getNotaTCC() {
        return notaTCC;
    }

    public void setNotaTCC(Double notaTCC) {
        this.notaTCC = notaTCC;
    }

    @Override
    public Double calcularMedia() {
        Double media = (getNotaEntrega() + getNotaPratica() + getNotaTCC() + getNotaArtigo()) / 4;
        System.out.println("Média do aluno: " + media);
        return media;
    }

}
