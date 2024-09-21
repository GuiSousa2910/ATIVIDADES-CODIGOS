package school.sptech;

public class PontoDeRecarga {

    private Integer qtdConsultasRealizadas;
    private Integer qtdRecargasRealizadas;

    public Integer getQtdConsultasRealizadas() {
        return qtdConsultasRealizadas;
    }

    public Integer getQtdRecargasRealizadas() {
        return qtdRecargasRealizadas;
    }

    public Double consultarSaldo(BilheteUnico bilhete) {
        if (bilhete.getBloqueado()) {
            System.out.println("Seu bilhete está bloqueado!");
            return 0.0;
        } else {
            qtdConsultasRealizadas++;
            return bilhete.getSaldo();
        }
    }

    public void recarregar(BilheteUnico bilhete, Double valor) {
        if (valor >= 5) {
            if (!bilhete.getBloqueado()) {
                bilhete.setSaldo(bilhete.getSaldo() + valor);
                qtdRecargasRealizadas++;
            } else {
                System.out.println("bilhete único bloqueado");
            }
        } else {
            System.out.println("Valor mínimo de recarga não atingido");
        }
    }

    public void bloquear(BilheteUnico bilhete) {
        bilhete.setBloqueado(true);
    }
}
