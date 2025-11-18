import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listaEncadeada = new LinkedList<>();
        listaEncadeada.add("Diego");
        listaEncadeada.add("jk");
        listaEncadeada.add("laise");

        System.out.println("Lista Encadeada:");
        System.out.println(listaEncadeada.getFirst());
        System.out.println(listaEncadeada.getLast());
    }
}