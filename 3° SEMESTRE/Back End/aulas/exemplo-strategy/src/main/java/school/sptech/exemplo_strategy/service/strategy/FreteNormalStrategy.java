package school.sptech.exemplo_strategy.service.strategy;

public class FreteNormalStrategy implements FreteStrategy{
    @Override
    public double calcular(double pesoEmKg) {
        return 10 + (pesoEmKg * 0.1);
    }
}
