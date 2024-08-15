public class CalculoDeRenda {
    public static void main(String[] args) {
        Integer qntFilhos0a3anos = 5;
        Integer qntFilhos4a16anos = 3;
        Integer qntFilhos17a18anos = 2;

        Double bolsa1 = qntFilhos0a3anos * 25.12;
        Double bolsa2 = qntFilhos4a16anos * 15.88;
        Double bolsa3 = qntFilhos17a18anos * 12.44;

        Double total = bolsa1 + bolsa2 + bolsa3;
        Integer qntFilhos = qntFilhos0a3anos + qntFilhos4a16anos + qntFilhos17a18anos;

        System.out.println("Você tem um total de %d filhos e vai receber R$%.2f de bolsa".formatted(qntFilhos, total));

    }
}
