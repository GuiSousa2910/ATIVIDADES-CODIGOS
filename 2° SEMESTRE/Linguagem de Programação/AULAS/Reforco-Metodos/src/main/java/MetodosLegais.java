import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class MetodosLegais {

    String avaliandoSorte(Integer n){
        Integer tentativas = 1;
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
        String resultado = "";
        while(!n.equals(numeroAleatorio)){
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
            tentativas += 1;
        }
        if (tentativas <= 3){
            resultado = "Você é MUITO sortudo";

        }else if (tentativas > 3 && tentativas <= 10){
            resultado = "Você é sortudo";
        }else{
            resultado = "É melhor você parar de apostar";
        }
        System.out.println(resultado);
        return resultado;
    }

    Integer exibeSomaSorteio(){
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
        Integer soma = 0;
        while (!numeroAleatorio.equals(0)){
            soma += numeroAleatorio;
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
        }
        System.out.println(soma);
        return soma;
    }

    void exibeImpares(){
        for (int i = 0; i <= 90; i++) {
            if((i%2) == 1){
                System.out.println(i);
            }
        }
    }

    Integer posicaoSorteio(Integer n){
        Boolean passou = false;
        Integer posicao = -1;
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 11);
        
        for (int i = 1; i <= 200; i++) {
            if (n.equals(numeroAleatorio)) {
                passou = true;
                posicao = i;
                break;
            }
            numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 11);
        }
        if (!passou){
            System.out.println("Não passou");
        }
        System.out.println("Posição: "+ posicao);
        return posicao;
    }
}
