public class BilheteUnico {

    String nomeTitular;
    Double saldo;
    String codigoBilhete;
    Integer qntVezesUsada;

    void carregar(Double valorRecarga) {
        if (valorRecarga > 0.0) {
            saldo += valorRecarga;
            System.out.println("Recarga Efetuada: " + saldo);
        } else {
            System.out.println("Recarga inválida");
        }
    }

    Boolean usar() {
        if (saldo >= 5.0) {
            saldo -= 5.0;
            qntVezesUsada++;
            return true;
        }
        else {
            return false;
        }
    }

}
