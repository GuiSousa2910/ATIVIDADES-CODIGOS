import java.util.ArrayList;
import java.util.List;

public class ListaNumeros {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1, 24, 10, 2));

        System.out.println("Lista de numeros completa: " + numeros);

        int indice = 1;
        numeros.remove(indice);
        System.out.println("Removendo o indice 1: "+ numeros);

        Integer valor = 1;
        numeros.remove(valor);
        System.out.println("Removendo o numero 1: "+ numeros);
    }
}
