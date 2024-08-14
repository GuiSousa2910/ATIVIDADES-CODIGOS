public class CalculoDeRenda {
    public static void main(String[] args) {
        Integer qntFilhos3anos = 5;
        Integer qntFilhos16anos = 3;
        Integer qntFilhos18anos = 2;

        Double bolsa1 = qntFilhos3anos * 25.12;
        Double bolsa2 = qntFilhos16anos * 15.88;
        Double bolsa3 = qntFilhos18anos * 12.44;

        Double total = bolsa1 + bolsa2 + bolsa3;
        Integer qntFilhos = qntFilhos3anos + qntFilhos16anos + qntFilhos18anos;

        System.out.println("Você tem um total de %d filhos e vai receber R$%.2f de bolsa".formatted(qntFilhos, total));

    }
}
