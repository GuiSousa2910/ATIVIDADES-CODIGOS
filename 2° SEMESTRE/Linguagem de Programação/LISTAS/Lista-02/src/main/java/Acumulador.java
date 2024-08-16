import java.util.concurrent.ThreadLocalRandom;

public class Acumulador {
    public static void main(String[] args) {
        Integer quantidadeDeNumeros = ThreadLocalRandom.current().nextInt(0, 11);
        Integer soma = 0;
        for (int i = 0; i < quantidadeDeNumeros; i++) {
            Integer numerosSorteados = ThreadLocalRandom.current().nextInt(0, 11);
            soma += numerosSorteados;
        }
        System.out.println("A soma dos números é: " + soma);
    }
}
