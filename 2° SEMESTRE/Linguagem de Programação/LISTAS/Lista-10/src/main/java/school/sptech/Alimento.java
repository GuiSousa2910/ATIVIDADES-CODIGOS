package school.sptech;

import java.time.LocalDate;

public class Alimento extends Produto {

    private LocalDate prazoValidade;

    public Alimento() {}

    public LocalDate getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(LocalDate prazoValidade) {
        this.prazoValidade = prazoValidade;
    }

    @Override
    public Double calcularImposto(){
        return getPrecoUnitario() * 0.03;
    }

    @Override public Boolean disponivelParaCompra(LocalDate dataAtual){
        if (getQuantidadeDisponivel() > 0 && dataAtual.isBefore(prazoValidade)){
            return true;
        } else {
            return false;
        }
    }
}
