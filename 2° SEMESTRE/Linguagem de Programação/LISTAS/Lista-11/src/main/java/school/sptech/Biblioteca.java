package school.sptech;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {
    }

    public Biblioteca(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public void adicionarLivro(Livro livro) {
        if (livro != null) {
            if (livro.getTitulo() != null && !livro.getTitulo().isBlank()) {
                if (livro.getAutor() != null && !livro.getAutor().isBlank()) {
                    if (livro.getDataPublicacao() != null) {
                        livros.add(livro);
                    }
                }
            }
        }
    }

    public void removerLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(livro);
                break;
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }
        return null;
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        List<Livro> livrosAteAno = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                livrosAteAno.add(livro);
            }
        }
        return livrosAteAno;
    }

    public List<Livro> retornarTopCincoLivros(){
        List<Livro> topCinco = new ArrayList<>();
        for (int i = 0; i < livros.size(); i++) {
            if (i < 5) {
                topCinco.add(livros.get(i));
            }
            
        }
        return topCinco;
    }


}
