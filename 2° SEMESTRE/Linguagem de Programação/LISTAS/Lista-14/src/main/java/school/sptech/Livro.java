package school.sptech;

public class Livro extends Produto {

    private String autor;
    private String editora;
    private Integer qtdPaginas;
    private Formato formato;

    public Livro() {}

    public Livro(String nome, String autor, String editora, Integer qtdPaginas, Raridade raridade) {
        super(nome, raridade);
        this.autor = autor;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
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

        if (formato.getRaridade().equalsIgnoreCase("DIGITAL")) {
            return (getQtdPaginas() * 0.2) + ((getQtdPaginas() * 0.2) * porcentagem);
        } else if (formato.getRaridade().equalsIgnoreCase("COMUM")) {
            return (getQtdPaginas() * 0.3) + ((getQtdPaginas() * 0.3) * porcentagem);
        } else if (formato.getRaridade().equalsIgnoreCase("CAPA_DURA")) {
            return (getQtdPaginas() * 0.4) + ((getQtdPaginas() * 0.4) * porcentagem);
        } else {
            return 0.0;
        }
    }



}
