
import java.util.concurrent.ThreadLocalRandom;

public class Votacao {
    public static void main(String[] args) {

        Integer mussarela = 0;
        Integer calabresa = 0;
        Integer quatroQueijos = 0;
        String campeao;
        for (int i = 1; i <= 10; i++) {
            Integer saborAleatorio = ThreadLocalRandom.current().nextInt(1, 4);
            System.out.println(saborAleatorio);
            if (saborAleatorio.equals(1)){
                mussarela += 1;
            } else if (saborAleatorio.equals(2)) {
                calabresa += 1;
            }else {
                quatroQueijos += 1;
            }
        }

        if (mussarela > calabresa && mussarela > quatroQueijos){
            campeao = "Mussarela";
        } else if (calabresa > mussarela && calabresa > quatroQueijos) {
            campeao = "Calabresa";
        } else if (quatroQueijos > calabresa && quatroQueijos > mussarela){
            campeao = "Quatro Queijos";
        }else {
            campeao = "Empate";
        }
        System.out.println("""
                Calabresa teve: %d votos
                Mussarela teve: %d votos
                Quatro Queijos teve: %d votos
                E o resultado de sabor favorito é: %s
                """.formatted(calabresa, mussarela, quatroQueijos, campeao));
    }
}
