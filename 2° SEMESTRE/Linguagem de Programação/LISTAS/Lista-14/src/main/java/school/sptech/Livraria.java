package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Livraria {

    private String nome;
    private List<Produto> produtos;

    public Livraria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public void remover(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produtos.remove(produto);
                break;
            }
        }
    }

    public Double calcularTotalLivros() {
        Double soma = 0.0;
        for (Produto produto : produtos) {
            if (produto instanceof Livro) {
                soma += produto.calcularPreco();
            }
        }
        return soma;
    }

    public List<Livro> buscarLivrosPorFormato(Formato formato) {
        List<Livro> livros = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto instanceof Livro) {
                if (((Livro) produto).getFormato().equals(formato)) {
                    livros.add((Livro) produto);
                }
            }
        }
        return livros;
    }

    public List<Produto> buscarPorRaridade(Raridade raridade) {
        List<Produto> livros = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getRaridade().equals(raridade)) {
                livros.add(produto);
            }
        }
        return livros;
    }

    public Boolean existePorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public List<JogoTabuleiro> buscarPorQtdPecasMaior(Integer qtd){
        List<JogoTabuleiro> jogos = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto instanceof JogoTabuleiro) {
                if (((JogoTabuleiro) produto).getQtdPecas() > qtd) {
                    jogos.add((JogoTabuleiro) produto);
                }
            }
        }
        return jogos;
    }

}
