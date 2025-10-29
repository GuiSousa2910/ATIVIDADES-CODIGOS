package github.britooo;

public class InverterTextoStack {
    public static String inverter(String input) {
        Pilha pilha = new Pilha<>(input.length());
        StringBuilder s = new StringBuilder();

        char[] c = input.toCharArray();

        for (int i = 0; i < input.length() ; i++) {
            if (!pilha.isFull()){
                pilha.push(c[i]);
            }
        }

        while (!pilha.isEmpty()){
            s.append(pilha.pop());
        }
        return s.toString();
    }
}
