public class CalculoTroco {
    public static void main(String[] args) {
        Double preco = 3.21;
        Integer qntVendidas = 4;
        Double valorPago = 30.99;

        Double precoTotal = preco * qntVendidas;
        Double troco = valorPago - preco;

        System.out.println("Seu troco será de R$ %.2f.".formatted(troco));
    }
}
