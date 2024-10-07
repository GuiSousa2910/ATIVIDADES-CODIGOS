import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Contato> contatos;

    public Grupo(String nome) {
        this.nome = nome;
        this.contatos = new ArrayList<>();
    }

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }

    public void remover(String nome) {
        for (int i = 0; i < contatos.size(); i++) {
            Contato contatoDaVez = contatos.get(i);
            if (contatoDaVez.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(i);
            }
        }
    }

    public void removerPorTipo(String tipoRemover) {
        for (int i = 0; i < contatos.size(); i++) {
            Contato contatoDaVez = contatos.get(i);
            if (contatoDaVez.getTipoContato().equalsIgnoreCase(tipoRemover)) {
                contatos.remove(i);
            }
        }
    }

    public Integer getQuantidadeBloqueados() {
        Integer quantidadeBlock = 0;
        for (int i = 0; i < contatos.size(); i++) {
            Contato contatoDaVez = contatos.get(i);
            if (contatoDaVez.getBloqueado()) {
                quantidadeBlock++;
            }
        }
        return quantidadeBlock;
    }

    public Double somaValorDoacoes() {
        Double soma = 0.0;
        for (int i = 0; i < contatos.size(); i++) {
            Contato c = contatos.get(i);
            soma += c.getValorDoacao();
        }
        return soma;
    }
}
