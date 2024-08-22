import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        DesafioMetodos desafio = new DesafioMetodos();
        Scanner texto = new Scanner(System.in);
        System.out.println("Digite a primeira palavra: ");
        String t1 = texto.nextLine();
        System.out.println("Digite a segunda palavra: ");
        String t2 = texto.nextLine();

        System.out.println(desafio.palindromo(t1, t2));
    }
}
