package school.sptech.ex2;

public class TesteEncomendas {

    public static void main(String[] args) {
        Encomenda encomenda = new Encomenda();
        encomenda.valorProduto = 40.0;
        encomenda.tamanho = "M";
        encomenda.distancia = 32.3;
        encomenda.aplicarCupomDeDesconto(10);
        encomenda.calcularFrete();
        encomenda.valorTotalDaEncomenda();

        System.out.println("------------------------------------------");

        Encomenda encomenda2 = new Encomenda();
        encomenda2.valorProduto = 45.0;
        encomenda2.tamanho = "G";
        encomenda2.distancia = 312.3;
        encomenda2.aplicarCupomDeDesconto(1);
        encomenda2.calcularFrete();
        encomenda2.valorTotalDaEncomenda();
    }
}
