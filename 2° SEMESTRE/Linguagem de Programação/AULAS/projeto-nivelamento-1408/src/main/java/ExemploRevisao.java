public class ExemploRevisao {
    public static void main(String[] args) {

        //tipos de dados
        String nome = "Guilherme de Sousa";
        Integer idade = 18;
        Double altura = 1.82;
        Boolean bloqueado = true;

/*      boolean bloqueado2 = false;
        int idade2 = 15; */

        String nomePet;
        nomePet = "Woody";

        System.out.println("Meu nome é " + nome + "\nminha altura é " + altura + " \ne minha idade é " + idade);

        System.out.println("Meu nome é %s, minha altura é %.2f e minha idade é %d".formatted(nome, altura, idade));

        System.out.println(""" 
                Meu nome é %s
                Idade: %d
                Altura: %.2f
                """.formatted(nome, idade, altura));
    }
}
