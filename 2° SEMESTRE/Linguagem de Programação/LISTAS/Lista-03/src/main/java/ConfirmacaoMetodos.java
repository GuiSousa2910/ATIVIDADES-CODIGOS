public class ConfirmacaoMetodos {
    public static void main(String[] args) {
        ExercicioMetodos metodos = new ExercicioMetodos();

        Boolean maiorIdade = metodos.verificarIdade(19);
        System.out.println(maiorIdade);

        Double media = metodos.calcularMedia(2.0, 4.0, 10.0);
        System.out.println(media);

        Integer maiorNumero = metodos.maiorNumero(3, 9, 1);
        System.out.println(maiorNumero);

        Integer fatorial = metodos.calcularFatorial(5);
        System.out.println(fatorial);

        Boolean primo = metodos.valorPrimo(8);
        System.out.println(primo);

        Integer potencia = metodos.calcularPotencia(2, 3);
        System.out.println(potencia);

        Integer balas = metodos.calcularTrocoEmBalas(10.0, 20.0);
        System.out.println(balas);
    }
}
