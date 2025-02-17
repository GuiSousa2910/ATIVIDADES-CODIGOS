package school.sptech.aula_17_02;

public class Filme {
    private String titulo;
    private int anoLancamento;

    public Filme(){}

    public Filme(String titulo, int anoLancamento){
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
