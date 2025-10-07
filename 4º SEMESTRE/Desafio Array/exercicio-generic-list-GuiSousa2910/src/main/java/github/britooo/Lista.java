package github.britooo;

import java.util.Objects;

/**
 * Implementação de uma lista genérica baseada em array com crescimento dinâmico.
 *
 * @param <T> tipo dos elementos armazenados
 */
public class Lista<T> {

    private T[] elements;
    private int numElements;

    @SuppressWarnings("unchecked")
    public Lista() {
        this.elements = (T[]) new Object[4]; // capacidade inicial
        this.numElements = 0;
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newArray = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, numElements);
        elements = newArray;
    }

    // -------------------------------
    // INSERÇÃO
    // -------------------------------

    /**
     * Adiciona um elemento no final da lista.
     * Dobra a capacidade quando necessário.
     */
    public boolean add(T element) {
        if (numElements == elements.length) {
            expandCapacity();
        }
        elements[numElements++] = element;
        return true;
    }

    /**
     * Adiciona um elemento na posição indicada, deslocando os demais à direita.
     * Lança IndexOutOfBoundsException se index < 0 ou index > size().
     */
    public boolean add(int index, T element) {
        if (index < 0 || index > numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }

        if (numElements == elements.length) {
            expandCapacity();
        }

        // Desloca elementos para a direita
        for (int i = numElements; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        numElements++;
        return true;
    }

    /**
     * Adiciona todos os elementos de outra lista, mantendo a ordem.
     * Retorna false se a lista origem estiver vazia.
     * Lança NullPointerException se other == null.
     */
    public boolean addAll(Lista<T> other) {
        if (other == null) {
            throw new NullPointerException("Lista não pode ser null");
        }

        if (other.isEmpty()) {
            return false;
        }

        // Expande capacidade se necessário
        while (numElements + other.size() > elements.length) {
            expandCapacity();
        }

        for (int i = 0; i < other.size(); i++) {
            elements[numElements++] = other.get(i);
        }

        return true;
    }

    /**
     * Substitui o valor em index pelo novo elemento e retorna o valor antigo.
     * Lança IndexOutOfBoundsException se index inválido.
     */
    public T set(int index, T element) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }

        T oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    // -------------------------------
    // ACESSO
    // -------------------------------

    /**
     * Retorna o elemento na posição indicada.
     * Lança IndexOutOfBoundsException se index inválido.
     */
    public T get(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }
        return elements[index];
    }

    /**
     * Retorna a quantidade de elementos armazenados.
     */
    public int size() {
        return numElements;
    }

    /**
     * Retorna true se a lista estiver vazia.
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    // -------------------------------
    // REMOÇÃO
    // -------------------------------

    /**
     * Remove o elemento na posição indicada e retorna o valor removido.
     * Desloca os elementos seguintes para a esquerda.
     * Lança IndexOutOfBoundsException se index inválido.
     */
    public T remove(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }

        T removedElement = elements[index];

        for (int i = index; i < numElements - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--numElements] = null;
        return removedElement;
    }

    /**
     * Remove a primeira ocorrência do elemento informado (comparação por equals, suportando null).
     * Retorna true se removeu.
     */
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Remove todos os elementos; mantém a capacidade.
     */
    public void clear() {
        for (int i = 0; i < numElements; i++) {
            elements[i] = null;
        }
        numElements = 0;
    }

    // -------------------------------
    // CONSULTA
    // -------------------------------

    /**
     * Retorna true se a lista contiver o elemento informado (suporta null).
     */
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    /**
     * Retorna a posição da primeira ocorrência do elemento (ou -1 se não existir).
     * Suporta busca por null.
     */
    public int indexOf(T element) {
        for (int i = 0; i < numElements; i++) {
            if (Objects.equals(element, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna a posição da última ocorrência do elemento (ou -1 se não existir).
     * Suporta busca por null.
     */
    public int lastIndexOf(T element) {
        for (int i = numElements - 1; i >= 0; i--) {
            if (element == null ? elements[i] == null : element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
}
