public class ProjetoTesteMatematicos {
    public static void main(String[] args) {

        Double n1 = 42.0;
        Double n2 = 10.1;

        MetodosUteis metodosUteis = new MetodosUteis();

        Double resultadoSoma = metodosUteis.somar(n1,n2);
        System.out.println(resultadoSoma);
    }
}
