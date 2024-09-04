import java.util.Scanner;

public class ExemploSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero entre 1 e 7: ");
        Integer dia = scanner.nextInt();

//        switch (dia){
//            case 1:
//                System.out.println("Domingo");
//        }
        
//        switch (dia){
//            case 1 -> {
//                System.out.println("Domingo");
//            }
//        }

        String texto = switch (dia) {
            case 1 -> "Domingo";
            case 2 -> "Segunda";
            case 3 -> "Terça";
            case 4 -> "Quarta";
            case 5 -> "Quinta";
            case 6 -> "Sexa";
            case 7 -> "Sabado";
            default -> "Errou";
        };
        System.out.println(texto);
    }
}

