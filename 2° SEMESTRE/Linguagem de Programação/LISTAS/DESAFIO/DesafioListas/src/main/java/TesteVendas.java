import java.util.ArrayList;
import java.util.List;

public class TesteVendas {
    public static void main(String[] args) {

        Metodos metodos = new Metodos();

        List<Double> lista = new ArrayList<>();
        lista.add(40.0);
        lista.add(3.5);

        System.out.println(metodos.buscarQuantidadeVendas(lista));
        System.out.println(metodos.somarVendas(lista));
        System.out.println(metodos.buscarPreco(lista,3.5));
        System.out.println(metodos.buscarMaiorPreco(lista));
        System.out.println(metodos.buscarMenorPreco(lista));
        System.out.println(metodos.buscarPorPrecoMinimo(lista, 4.0));
    }
}
