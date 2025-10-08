package school.sptech;

import java.util.EmptyStackException;

public class Pilha<E> {

    private E[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        this.elementos = (E[]) new Object[capacidade];
        this.topo = -1;
    }

    // Deve lançar - StackOverflowError
    public E push(E elemento) {
        if (!isFull()){
            elementos[++topo] = elemento;
            return elemento;
        }
        else {
            throw new StackOverflowError();
        }
    }

    //  Deve lançar - EmptyStackException
    public E pop() {
        if (!isEmpty()){
            E element = elementos[topo];
            topo--;
            return element;
        // return elementos[topo--]
        }
        else {
            throw new EmptyStackException();
        }

    }

    //  Deve lançar - EmptyStackException
    public E peek() {
        if (!isEmpty()){
            return elementos[topo];
        }else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        if (capacity() == topo + 1){
            return true;
        }

        return false;

        // return topo = elementos.length - 1
    }

    public int size() {
        return topo + 1;
    }

    public int capacity() {
        return elementos.length;
    }

    public void clear() {
         this.topo = -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "📭 Pilha vazia []";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("📚 Pilha [").append(size()).append("/").append(capacity()).append("]:\n");

        for (int i = topo; i >= 0; i--) {
            sb.append("  ");
            if (i == topo) {
                sb.append("🔝 ");
            } else {
                sb.append("   ");
            }
            sb.append("| ").append(elementos[i]).append(" |\n");
        }
        sb.append("  └─────┘");

        return sb.toString();
    }
}