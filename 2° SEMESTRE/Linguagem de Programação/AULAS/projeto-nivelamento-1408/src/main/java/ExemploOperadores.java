public class ExemploOperadores {
    public static void main(String[] args) {
        Double n1 = 42.0;
        Double n2 = 10.0;

        System.out.println("Soma: " + (n1 + n2) );
        System.out.println("Multiplicação: " + (n1 * n2) );
        System.out.println("Divisão: " + (n1 / n2) );
        System.out.println("Subtração: " + (n1 - n2) );

        Double resultadoPotencia = Math.pow(n1, n2);
    }
}
