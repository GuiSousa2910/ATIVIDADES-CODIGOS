import java.util.ArrayList;
import java.util.List;

public class Metodos {

    Integer buscarQuantidadeVendas(List<Double> precos){
        Integer qntPrecos = precos.size();
        return qntPrecos;
    }

    Double somarVendas(List<Double> precos){
        Double soma = 0.0;

        for (int i = 0; i < precos.size(); i++) {
            soma += i;
        }

        return soma;
    }

    Boolean buscarPreco(List<Double> precos, Double preco){
        if (precos.contains(preco)){
            return true;
        }
        else{
            return false;
        }
    }

    Double buscarMaiorPreco(List<Double> precos){
        Double nMaior = 0.0;
        for (int i = 0; i < precos.size(); i++) {
            if (precos.get(i) > nMaior){
                nMaior = precos.get(i);
            }
        }
        return nMaior;
    }

    Double buscarMenorPreco(List<Double> precos){
        Double nMenor = 0.0;
        for (int i = 0; i < precos.size(); i++) {
            if (precos.get(i) < nMenor){
                nMenor = precos.get(i);
            }
        }
        return nMenor;
    }

    List<Double> buscarPorPrecoMinimo(List<Double> precos, Double filtro){
        List<Double> novaLista = new ArrayList<>();

        for (int i = 0; i < precos.size(); i++) {
            if (precos.get(i) >= filtro){
                novaLista.add(precos.get(i));
            }
        }
        return novaLista;
    }
}
