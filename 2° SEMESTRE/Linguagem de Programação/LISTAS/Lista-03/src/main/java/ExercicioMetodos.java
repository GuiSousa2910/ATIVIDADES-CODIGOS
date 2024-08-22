public class ExercicioMetodos {
    Boolean verificarIdade(Integer idade){
        if (idade >= 18){
            return true;
        }else{
            return false;
        }
    }

    Double calcularMedia(Double valor1, Double valor2, Double valor3){
        Double media = (valor1 + valor2 + valor3) / 3;
        return media;
    }

    Integer maiorNumero(Integer valor1, Integer valor2, Integer valor3){
        if (valor1 > valor2 && valor1 > valor3){
            return valor1;
        } else if (valor2 > valor1 && valor2 > valor3) {
            return valor2;
        }else{
            return valor3;
        }
    }

    Integer calcularFatorial(Integer valor){
        Integer mult = 1;

        for (int i = valor; i > 0; i-- , valor--) {
            System.out.println("Multiplicao: "+ mult);
            mult *= valor;
        }
        return mult;
    }

    Boolean valorPrimo(Integer valor){

        if (valor < 2){
            return false;
        }
        for (int i = 2; i <= valor / 2; i++) {
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }

    Integer calcularPotencia(Integer base, Integer expoente){
        Integer resultado = 1;
        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    Integer calcularTrocoEmBalas(Double valorCompra, Double valorRecebido) {
        Double precoBala = 0.25;
        Double troco = valorRecebido - valorCompra;
        int qntBalas;
        for (qntBalas = 0; precoBala <= troco; qntBalas++) {
            troco = troco - precoBala;
        }
        return qntBalas;
    }



}

