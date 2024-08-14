import java.util.concurrent.ThreadLocalRandom;

public class ExemploLacosRepeticao {
    public static void main(String[] args) {
        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }

        Integer contador = 0;
        while (contador <= 10){
            System.out.println(contador);
            contador++;
        }
        System.out.println("Terminei o uai");

        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);

        while(numeroAleatorio != 3){
            System.out.println("Numero errado: " + numeroAleatorio);
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
        }
        System.out.println("3 foi sorteado!!");

    }
}