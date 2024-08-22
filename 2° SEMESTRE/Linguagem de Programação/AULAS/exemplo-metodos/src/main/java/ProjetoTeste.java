import java.util.Scanner;

public class ProjetoTeste {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        MetodosUteis util = new MetodosUteis();

        System.out.println("Digite o nome: ");
        String nomeScanner = leitor.nextLine();
        String nomeUsuario = "Bob da Silva";

        util.exibirUsuario(nomeUsuario);
        util.exibirUsuario("Guilherme");
        util.exibirUsuario(nomeScanner);

    }
}
