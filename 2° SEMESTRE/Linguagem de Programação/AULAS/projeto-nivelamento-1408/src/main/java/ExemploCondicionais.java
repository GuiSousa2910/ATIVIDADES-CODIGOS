public class ExemploCondicionais {
    public static void main(String[] args) {
        Integer idade = 19;

        if (idade >= 18) {
            System.out.println("Maior de idade");
        } else{
            System.out.println("É menor de idade");
        }

        String nome1 = "Bob";
        String nome2 = "Bob";

        if (nome1.equals(nome2)){
            System.out.println("Nomes iguais");
        }else{
            System.out.println("Nomes diferentes");
        }

        String resultadoMaioridade = idade >= 18 ? "Sim" : "Não";
        System.out.println("É maior de idade: " + resultadoMaioridade);

    }
}
