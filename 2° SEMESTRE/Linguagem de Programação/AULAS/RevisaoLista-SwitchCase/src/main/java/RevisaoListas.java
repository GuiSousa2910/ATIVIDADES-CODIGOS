import java.util.ArrayList;
import java.util.List;

public class RevisaoListas {
    public static void main(String[] args) {
        List<String> frutas = List.of("Laranja", "Goiaba", "Limão");

//        frutas.add("JK");
//        System.out.println(frutas);

        List<String> frutasImutaveis = new ArrayList<>(List.of("Laranja", "Goiaba", "Limão"));

        frutasImutaveis.add("Uva");
        System.out.println("Adicionando Uva: "+ frutasImutaveis);

        frutasImutaveis.remove("Laranja");
        System.out.println("Removendo laranja: "+ frutasImutaveis);

        frutasImutaveis.remove(2);
        System.out.println("Removendo pelo indice: " + frutasImutaveis);

        for (int i = 0; i < frutasImutaveis.size(); i++) {
            System.out.println("Fruta numero "+ i + "°: " + frutasImutaveis.get(i));
        }

        for(String frutaDaVez : frutasImutaveis){
            System.out.println("Interando lista com for aprimorado: " + frutaDaVez);
        }
    }
}
