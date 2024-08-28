import java.util.ArrayList;
import java.util.List;

public class ExemploLista {
    public static void main(String[] args) {
        List listaEstranha = new ArrayList();
        listaEstranha.add(true);
        listaEstranha.add("Bob");
        listaEstranha.add(42);

        List<String> nomes = new ArrayList<>();
        //palavras.add(false) -> isso nao funciona pq limitei para String em cima
        nomes.add("Bob da Silva");
        nomes.add("Jose");
        nomes.add("Maria");

        System.out.println("Segundo nome da lista: " + nomes.get(1));

        for (int i = 0; i < nomes.size() ; i++) {
            System.out.println("""
                    Nome %d: %s
                    """.formatted(i + 1, nomes.get(i)));
        }
        nomes.set(1, "Guilherme");

        MetodosListas metodos = new MetodosListas();
        metodos.exibeListaDeNomes(nomes);
    }
}
