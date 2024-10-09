package school.sptech;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Eletronico extends Produto {

    private LocalDate dataFabricacao;
    private Boolean nacional;

    public Eletronico() {}

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Boolean getNacional() {
        return nacional;
    }

    public void setNacional(Boolean nacional) {
        this.nacional = nacional;
    }

    @Override
    public Double calcularImposto(){
        if (nacional) {
            return getPrecoUnitario() * 0.1;
        } else {
            return getPrecoUnitario() * 0.3;
        }
    }

    @Override
    public Boolean disponivelParaCompra(LocalDate dataAtual){
        ChronoUnit f = ChronoUnit.YEARS;
        if (getQuantidadeDisponivel() > 0 && (dataAtual.getYear() - dataFabricacao.getYear()) < 5){
            return true;
        } else {
            return false;
        }
    }




}
