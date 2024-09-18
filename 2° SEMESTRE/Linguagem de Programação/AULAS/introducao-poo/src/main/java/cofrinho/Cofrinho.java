package cofrinho;

import java.util.concurrent.ThreadLocalRandom;

public class Cofrinho {

    private String meta;
    private Double saldo;
    private Boolean quebrado;

    public Cofrinho(String meta, Boolean quebrado) {
        this.quebrado = quebrado;
        this.saldo = 0.0;
        this.meta = meta;
    }

    public Cofrinho(Boolean quebrado) {
        this.quebrado = quebrado;
        this.saldo = 0.0;
        meta = "Não possui";
    }

    void depositar(Double deposito) {
        if (podeDepositar(deposito)) {
            saldo += deposito;
            System.out.println("Valor depositado: " + deposito);
        } else {
            System.out.println("Erro");
        }
    }

    void depositar(Double deposito, Double valorDesconto) {
        if (podeDepositar(deposito)) {
            saldo += deposito - valorDesconto;
            System.out.println("Valor depositado: " + deposito + " com desconto de " + valorDesconto);
        } else {
            System.out.println("Erro");
        }
    }

    private Boolean podeDepositar(Double deposito) {
        if (!quebrado && deposito > 0.0) {
            return true;
        } else {
            return false;
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

    public String getMeta() {
        return meta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Boolean getQuebrado() {
        return quebrado;
    }
}