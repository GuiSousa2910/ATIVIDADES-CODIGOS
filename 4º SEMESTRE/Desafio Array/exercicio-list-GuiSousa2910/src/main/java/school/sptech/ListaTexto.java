package school.sptech;

public class ListaTexto {

    private String[] elements;
    private int numElements;

    public ListaTexto() {
        this.elements = new String[4];
        this.numElements = 0;
    }

    // -------------------------------
    // INSERÇÃO
    // -------------------------------
    public void resize(){
        String[] elementsNew = new String[elements.length*2];

        for (int i = 0; i < elements.length; i++) {
            elementsNew[i] = elements[i];
        }

        elements = elementsNew;
    }

    /**
     * Adiciona um elemento no final da lista.
     * Se o array estiver cheio, deve dobrar de tamanho (resize).
     * Retorna true se conseguiu inserir.
     */
    public boolean add(String element) {
        if (elements.length == numElements){
            resize();
        }

        elements[numElements] = element;
        numElements++;
        return true;
    }

    /**
     * Adiciona um elemento em uma posição específica da lista.
     * Deve "empurrar" os elementos seguintes uma posição à frente.
     * Se index for inválido, deve lançar exceção.
     */
    public boolean add(int index, String element) {
        if (index < 0 || index > numElements) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        for (int i = numElements - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        elements[index] = element;
        numElements++;
        return true;
    }

    /**
     * Adiciona todos os elementos de um array na lista atual.
     * Pode chamar add(String) para cada item.
     * Retorna true se pelo menos um elemento foi adicionado.
     */
    public boolean addAll(ListaTexto other) {
        boolean teveAdicao = false;

        for (int i = 0; i < other.numElements; i++) {
            add(other.elements[i]);
            teveAdicao = true;
        }

        return teveAdicao;
    }

    /**
     * Substitui o valor da posição indicada por outro.
     * Retorna o valor antigo que estava nessa posição.
     * Se index for inválido, deve lançar exceção.
     */
    public String set(int index, String element) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        String stringAnterior = elements[index];

        elements[index] = element;

        return stringAnterior;
    }

    // -------------------------------
    // ACESSO
    // -------------------------------

    /**
     * Retorna o elemento na posição indicada.
     * Se index for inválido, deve lançar exceção.
     */
    public String get(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        return elements[index];
    }

    /**
     * Retorna a quantidade de elementos armazenados (não a capacidade do array).
     */
    public int size() {
        return numElements;
    }

    /**
     * Retorna true se a lista estiver vazia (size == 0).
     */
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }

    // -------------------------------
    // REMOÇÃO
    // -------------------------------

    /**
     * Remove o elemento na posição indicada.
     * Deve "puxar" os elementos seguintes para trás.
     * Retorna o valor removido.
     */
    public String remove(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        String elementoRemovido = elements[index];

        for (int i = index; i < numElements-1; i++) {
            elements[i] = elements[i+1];
        }

        elements[numElements - 1] = null;

        numElements--;
        return elementoRemovido;
    }

    /**
     * Remove a primeira ocorrência do elemento informado.
     * Retorna true se encontrou e removeu.
     */
    public boolean remove(String element) {
        for (int i = 0; i < numElements-1; i++) {
            if (elements[i] == element){
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove todos os elementos da lista (zerar numElements).
     * Mantém a capacidade do array.
     */
    public void clear() {
        for (String itemDaVez : elements) {
            itemDaVez = null;
        }
        numElements = 0;
    }

    // -------------------------------
    // CONSULTA
    // -------------------------------

    /**
     * Retorna true se a lista contiver o elemento informado.
     */
    public boolean contains(String element) {
//        for (String elementDaVez : elements) {
//            if (elementDaVez.contains(element)){
//                return true;
//            }
//        }


        for (int i = 0; i < numElements; i++) {
            if (element == null) {
                if (elements[i] == null) return true;
            } else {
                if (elements[i] != null && elements[i].contains(element)) return true;
            }
        }
        return false;
    }

    /**
     * Retorna a posição da primeira ocorrência do elemento.
     * Se não existir, retorna -1.
     */
    public int indexOf(String element) {
        for (int i = 0; i < numElements-1; i++) {
            if (elements[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna a posição da última ocorrência do elemento.
     * Se não existir, retorna -1.
     */
    public int lastIndexOf(String element) {
        for (int i = numElements-1; i >= 0 ; i--) {
            if (elements[i] == element){
                return i;
            }
        }
        return -1;
    }
}