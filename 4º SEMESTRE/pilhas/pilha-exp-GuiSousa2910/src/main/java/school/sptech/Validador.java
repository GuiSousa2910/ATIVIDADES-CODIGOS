package school.sptech;

public class Validador {

    public static boolean validarExpressao(String expressao) {
        Pilha pilha = new Pilha<>(expressao.length());
        char[] listaExpressao = expressao.toCharArray();
        StringBuilder listaExpressaoInversa = new StringBuilder();
        int contagemParentesesAbertos = 0;
        int contagemChavesAbertos = 0;
        int contagemColcheteAbertos = 0;

        if (expressao == ""){
            return true;
        }

        for (int i = 0; i < expressao.length(); i++) {
            if (listaExpressao[0] == ')' || listaExpressao[0] == '}' || listaExpressao[0] == ']'){
                return false;
            }

            if (!pilha.isFull()){
                pilha.push(listaExpressao[i]);
            }
        }

        while (!pilha.isEmpty()){
            listaExpressaoInversa.append(pilha.pop());
        }

        if (listaExpressao === listaExpressaoInversa){

        }

        return true;
    }
}
