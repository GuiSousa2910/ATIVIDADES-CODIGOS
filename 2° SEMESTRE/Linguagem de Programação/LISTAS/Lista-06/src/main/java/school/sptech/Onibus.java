package school.sptech;

public class Onibus {

    private Integer qtdPassageiros;
    private Double valorPassagem;

    public Integer getQtdPassageiros() {
        return qtdPassageiros;
    }

    public Double getValorPassagem() {
        return valorPassagem;
    }

    public void cobrarPassagem(BilheteUnico bilheteUnico) {
        if (!bilheteUnico.getBloqueado()) {
            if (bilheteUnico.getSaldo() >= valorPassagem) {
                if (bilheteUnico.getEstudante()) {
                    valorPassagem /=  2;
                }
                System.out.println("PASSAGEIROS: "+ getQtdPassageiros());
                bilheteUnico.setSaldo(bilheteUnico.getSaldo() - valorPassagem);
                qtdPassageiros++;
            } else {
                System.out.println("Não há saldo suficiente para realizar a operação");
            }
        } else {
            System.out.println("bilhete único bloqueado");
        }
    }

    public void cobrarPassagem(Double dinheiro) {
        if (dinheiro >= valorPassagem){
            qtdPassageiros++;
        }else {
            System.out.println("Dinheiro insuficiente para realizar operação");
        }
    }

}
