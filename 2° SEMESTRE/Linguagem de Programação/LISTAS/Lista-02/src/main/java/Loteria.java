import java.util.concurrent.ThreadLocalRandom;

public class Loteria {
    public static void main(String[] args) {
        Integer numero = 3;
        Integer numeroSorteado = ThreadLocalRandom.current().nextInt(0, 11);
        Integer tentativas = 0;

        while(!numeroSorteado.equals(numero)){
            tentativas++;
            numeroSorteado = ThreadLocalRandom.current().nextInt(0, 11);
        }

            if (tentativas <= 3){
                System.out.println("Você é MUITO sortudo");
            } else if (tentativas >= 4 && tentativas <= 10) {
                System.out.println("Você é sortudo");
            } else {
                System.out.println("É melhor você parar de apostar e ir trabalhar");
            }
    }
}
