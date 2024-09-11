import java.util.concurrent.ThreadLocalRandom;

public class Cofrinho {

    String meta;
    Double saldo = 0.0;
    Boolean quebrado = false;

    void depositar(Double deposito) {
        if (!quebrado && deposito > 0.0) {
            saldo += deposito;
            System.out.println("Valor depositado: " + deposito);
        } else {
            System.out.println("Erro");
        }
    }

    Double agitar() {
        if (!quebrado) {
            Double retirada = ThreadLocalRandom.current().nextDouble(0, saldo);
            saldo -= retirada;
            System.out.println("Perdeu " + retirada + " ficando com " + saldo);
            return retirada;
        } else {
            return null;
        }
    }

    Double quebrar() {
        if (!quebrado) {
            Double valorAntes = saldo;
            quebrado = true;
            saldo = 0.0;
            return valorAntes;
        }
        return null;
    }

}
