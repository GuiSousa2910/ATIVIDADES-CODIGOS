package school.sptech.ex2;

public class Encomenda {

    String tamanho;
    String enderecoRemetente;
    String enderecoDestinatario;
    Double distancia;
    Double valorProduto;

    Double calcularFrete() {
        Double adicionalTamanho = 0.0;
        Integer adicionalDistancia;

        if (tamanho.equals("P")) {
            adicionalTamanho = valorProduto * 0.01;
        } else if (tamanho.equals("M")) {
            adicionalTamanho = valorProduto * 0.03;
        } else if (tamanho.equals("G")) {
            adicionalTamanho = valorProduto * 0.05;
        } else {
            System.out.println("Tamanho invalido");
        }

        if (distancia < 50) {
            adicionalDistancia = 3;
        } else if (distancia >= 50 && distancia <= 200) {
            adicionalDistancia = 5;
        } else {
            adicionalDistancia = 7;
        }

        Double frete = adicionalTamanho + adicionalDistancia;
        return frete;
    }

    void aplicarCupomDeDesconto(Integer porcentagemDesconto) {
        if (porcentagemDesconto > 100) {
            System.out.println("Cupom inválido");
        } else {
            Double apos = valorProduto * porcentagemDesconto;
            Double x = apos / 100;
            valorProduto = valorProduto - x;
            System.out.println("Com um desconto de " + porcentagemDesconto + "% o valor ficou: " + valorProduto);
        }
    }

    Double valorTotalDaEncomenda() {
        Double valorTotal = valorProduto + calcularFrete();
        System.out.println("Com um frete de " + calcularFrete() + " o valor do produto ficou " + valorTotal);
        return valorTotal;
    }

}
