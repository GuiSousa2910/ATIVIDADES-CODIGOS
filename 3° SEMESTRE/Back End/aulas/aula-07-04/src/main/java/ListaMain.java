public class ListaMain {
    public static void main(String[] args) {
        ListaEstatica listaEstatica = new ListaEstatica(3);

        listaEstatica.add("teste");
        listaEstatica.add("teste2");
        listaEstatica.add("teste3");
        listaEstatica.add("teste4");

        System.out.println(listaEstatica);


    }
}
