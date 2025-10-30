public class Easy {

    /**
     * Calcula o fatorial de um número inteiro positivo.
     * <p>
     * Exemplo:
     * fatorial(5) → 120
     * <p>
     * Objetivo:
     * Implementar uma função recursiva que multiplica o número atual
     * pelo resultado da chamada recursiva com (n - 1).
     *
     * @param n número inteiro (≥ 0)
     * @return fatorial de n
     */
    public static long fatorial(int n) {
        if (n == 0){
            return 1;
        }else {
            return n * fatorial(n-1);
        }
    }

    /**
     * Imprime uma contagem regressiva de n até 1.
     * <p>
     * Exemplo:
     * contagem(5) → "5 4 3 2 1"
     * <p>
     * Objetivo:
     * Criar uma função recursiva que imprima os números de n até 1,
     * decrementando o valor em cada chamada.
     *
     * @param n número inteiro (≥ 0)
     *          return        void
     */
    public static void contagem(int n) {
        if (n == 0){
            return;
        }else {
            System.out.print(n + " ");
            contagem(n-1);
        }
    }

    /**
     * Calcula a soma dos números de 1 até n.
     * <p>
     * Exemplo:
     * soma(5) → 15 (1 + 2 + 3 + 4 + 5)
     * <p>
     * Objetivo:
     * Desenvolver uma função recursiva que some todos os números
     * de 1 até n.
     *
     * @param n número inteiro (≥ 0)
     * @return soma de 1 até n
     */
    public static int soma(int n) {
        if (n > 0){
            return n + soma(n-1);
        }else {
            return 0;
        }
    }
}
