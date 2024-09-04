import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Integer escolha = 0;

        while (!escolha.equals(4)) {
        System.out.println("""
                1 - Somar
                2 - Subtrair
                3 - Multiplicar
                4 - Sair
                """);

        escolha = leitor.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.println("Digite o 1° numero: ");
                        Integer n1 = leitor.nextInt();
                        System.out.println("Digite o 2° numero: ");
                        Integer n2 = leitor.nextInt();
                        System.out.println("Resultado: " + (n1 + n2));
                        break;
                    case 2:
                        System.out.println("Digite o 1° numero: ");
                        n1 = leitor.nextInt();
                        System.out.println("Digite o 2° numero: ");
                        n2 = leitor.nextInt();
                        System.out.println("Resultado: " + (n1 - n2));
                        break;
                    case 3:
                        System.out.println("Digite o 1° numero: ");
                        n1 = leitor.nextInt();
                        System.out.println("Digite o 2° numero: ");
                        n2 = leitor.nextInt();
                        System.out.println("Resultado: " + (n1 * n2));
                        break;
                    case 4:
                        System.out.println("Sistema encerrado");
                }
        }
    }
}
