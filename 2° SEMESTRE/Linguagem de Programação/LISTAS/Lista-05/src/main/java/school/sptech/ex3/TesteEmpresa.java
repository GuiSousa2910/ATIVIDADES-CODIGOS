package school.sptech.ex3;

public class TesteEmpresa {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.salario = 9000.0;
        funcionario.reajustarSalario(10);
        funcionario.calcularValorHora();
        funcionario.calcularHoraExtra(10, 100);

        System.out.println("---------------------");

        Funcionario funcionario2 = new Funcionario();
        funcionario2.salario = 1000.0;
        funcionario2.reajustarSalario(10);
        funcionario2.calcularValorHora();
        funcionario2.calcularHoraExtra(15, 100);
    }
}
