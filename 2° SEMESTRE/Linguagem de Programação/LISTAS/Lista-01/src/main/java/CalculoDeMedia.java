public class CalculoDeMedia {
    public static void main(String[] args) {
        String nome = "Guilherme";
        Double nota1 = 9.5;
        Double nota2 = 2.5;
        Double media = (nota1 + nota2) / 2;

        System.out.println("Olá, %s. Sua média foi de %.2f".formatted(nome, media));
    }
}
