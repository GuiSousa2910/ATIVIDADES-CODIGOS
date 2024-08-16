
import java.util.concurrent.ThreadLocalRandom;

public class Sorteio {
    public static void main(String[] args) {
        Integer numero = 66;
        Integer par = 0;
        Integer impar = 0;
        Integer igual = 0;

        for (int i = 0; i < 200 ; i++) {
            Integer numeroGerado = ThreadLocalRandom.current().nextInt(0, 101);
            if ((numeroGerado % 2) == 0){
                par++;
            }else {
                impar++;
            }
            System.out.println(numeroGerado);
            if (numeroGerado.equals(numero)){
                if (!igual.equals(0)){

                }else {
                    igual = i;
                }
            }
        }
        System.out.println("""
                O numero foi gerado pela primeira vez na posição: %d
                Quantidade de numeros pares: %d
                Quantidade de numeros impares: %d 
                """.formatted(igual, par, impar));
    }
}