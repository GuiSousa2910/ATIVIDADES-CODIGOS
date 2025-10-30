/**
 * Classe com exercícios de recursão de nível intermediário.
 * <p>
 * Cada método deve ser resolvido utilizando recursividade,
 * sem o uso de estruturas de repetição (for/while).
 */
public class Medium {

    /**
     * Retorna quantas vezes um determinado caractere aparece em uma string.
     * <p>
     * Exemplo:
     * countOccurrences("banana", 'a') → 3
     * <p>
     * Objetivo:
     * Desenvolver uma função recursiva capaz de percorrer uma string
     * e contar as ocorrências de um caractere específico.
     *
     * @param text   Texto onde buscar
     * @param target Caractere a ser contado
     * @return Quantidade de ocorrências do caractere alvo
     */
    public static int countOccurrences(String text, char target) {
        if (text.isEmpty()) {
            return 0;
        } else {
            int count = (text.charAt(0) == target) ? 1 : 0;
            return count + countOccurrences(text.substring(1), target);
        }
    }
}
