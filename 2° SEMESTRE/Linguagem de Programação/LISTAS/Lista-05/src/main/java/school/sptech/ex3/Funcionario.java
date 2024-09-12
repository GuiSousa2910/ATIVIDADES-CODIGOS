package school.sptech.ex3;

public class Funcionario {

    String nome;
    String cargo;
    Double salario;

    void reajustarSalario(Integer porcentagemReajuste) {
        Double apos = (porcentagemReajuste / 100.0) + 1;
        salario = salario * apos;
        System.out.println("Com um aumento de " + porcentagemReajuste + "% no seu salario ele ficou: " + salario);
    }

    Double calcularValorHora() {
        Double valorHora = salario / 220;
        return valorHora;
    }

    Double calcularHoraExtra(Integer qntHorasEx, Integer addNoturno) {
        Double valorHora = calcularValorHora();
        Double valorHoraExtra = valorHora * ((addNoturno / 100.0) + 1);
        Double valorTotalEx = valorHoraExtra * qntHorasEx;
        System.out.println("Pela sua quantidade de horas extras voce receberá um adicional de: " + valorTotalEx);
        return valorTotalEx;
    }

}
