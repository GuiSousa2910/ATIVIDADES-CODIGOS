package school.sptech;

import java.util.List;

public class Carrinho {

    private String cliente;
    private List<Produto> produtos;

    public Integer getQuantidade() {
        return produtos.size();
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public Boolean existsPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().toUpperCase().equals(nome.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public Integer getQuantidadePorCategoria(String nome) {
        Integer qnt = 0;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCategoria().toUpperCase().equals(nome.toUpperCase())) {
                qnt++;
            }
        }
        return qnt;
    }

    public void limpar() {
        produtos.clear();
    }

    public void removerPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().toUpperCase().equals(nome.toUpperCase())) {
                produtos.remove(i);
            }
        }
    }

    public Produto getPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                return produtos.get(i);
            }
        }
        return null;
    }

    public Double getValorTotal() {
        Double precoTotal = 0.0;
        for (int i = 0; i < produtos.size(); i++) {
            precoTotal += produtos.get(i).getPreco();
        }
        return precoTotal;
    }
}

