/**
 * Classe com desafios de recursão de nível difícil.
 */
public class Hard {

    /**
     * Calcula a soma dos dígitos de um número inteiro positivo.
     * <p>
     * Exemplo:
     * sumDigits(123) → 6
     * sumDigits(405) → 9
     * <p>
     * Objetivo:
     * Criar uma função recursiva que percorra cada dígito de um número inteiro
     * e retorne a soma total desses dígitos.
     *
     * @param number Número inteiro positivo
     * @return Soma dos dígitos
     */
    public static int sumDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return (number % 10) + sumDigits(number / 10);
    }

    /**
     * Retorna o n-ésimo número da sequência de Fibonacci.
     * <p>
     * Exemplo:
     * fibonacci(7) → 13
     * <p>
     * Objetivo:
     * Implementar a sequência de Fibonacci de forma recursiva:
     * f(n) = f(n - 1) + f(n - 2)
     *
     * @param n posição desejada (≥ 0)
     * @return número de Fibonacci correspondente
     */
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0L;
        } else if (n == 1) {
            return 1L;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
