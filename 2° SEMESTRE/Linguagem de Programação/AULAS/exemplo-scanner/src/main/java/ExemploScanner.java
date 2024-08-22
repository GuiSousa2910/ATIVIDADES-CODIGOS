import java.util.Scanner;

public class ExemploScanner {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nomeUsuario = leitor.nextLine();

        System.out.println("Digite sua idade:");
        Integer idade = leitor.nextInt();

        System.out.println("Digite sua altura");
        Double altura = leitor.nextDouble();

        System.out.println("""
                Nome digitado foi: %s
                Sua idade é: %d
                Sua altura é: %.2f
                """.formatted(nomeUsuario,idade,altura));
    }
}
