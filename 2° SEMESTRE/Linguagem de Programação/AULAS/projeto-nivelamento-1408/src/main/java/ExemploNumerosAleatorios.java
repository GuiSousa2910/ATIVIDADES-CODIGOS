import java.util.concurrent.ThreadLocalRandom;

public class ExemploNumerosAleatorios {
    public static void main(String[] args) {

        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
        System.out.println(numeroAleatorio);
    }
}
