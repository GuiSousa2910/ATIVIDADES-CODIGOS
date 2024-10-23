package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Livro() {}

    public Livro(String titulo, String autor, LocalDate dataPublicacao, List<Avaliacao> avaliacoes) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) {
        if (descricao != null && !descricao.isBlank() && qtdEstrelas != null) {
            if (qtdEstrelas >= 0 && qtdEstrelas <= 5) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setDescricao(descricao);
                avaliacao.setQtdEstrelas(qtdEstrelas);
                avaliacoes.add(avaliacao);
            }
        }
    }

    public Double calcularMediaAvaliacoes() {
        Double soma = 0.0;
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        for (int i = 0; i < avaliacoes.size(); i++) {
            Avaliacao aV = avaliacoes.get(i);

            soma += aV.getQtdEstrelas();
        }
        return soma / avaliacoes.size();
    }



}