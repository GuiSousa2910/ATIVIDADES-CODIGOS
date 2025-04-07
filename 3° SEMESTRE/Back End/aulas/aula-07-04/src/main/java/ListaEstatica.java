public class ListaEstatica {
    String[] vetor;
    int nroElem;

    public ListaEstatica(int tam) {
        this.vetor = new String[tam];
        this.nroElem = 0;
    }

    public void add(String novoElemento) {
        if (nroElem >= vetor.length) {
            String[] novoVetor = new String[vetor.length * 2];
            for (int i = 0; i < vetor.length; i++) {
                novoVetor[i] = vetor[i];
            }
            vetor = novoVetor;
            vetor[nroElem] = novoElemento;
            nroElem++;
        } else {
            vetor[nroElem] = novoElemento;
            nroElem++;
        }
    }

    @Override
    public String toString() {
        String lista = "";

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                lista += vetor[i] + "\n";
            }
        }
        return lista.toString();
    }

    public String get(int index) {
        if (index < 0 || index <= nroElem) {
            if (vetor[index] != null) {
                System.out.println(vetor[index]);
                return vetor[index];
            }
            throw new ArrayIndexOutOfBoundsException("Nao achei");
        }
        throw new ArrayIndexOutOfBoundsException("Nao achei");
    }

    public Boolean remove(int index) {
        if (index < 0 || index <= nroElem) {
            if (vetor[index] != null) {
                vetor[index] = null;
                return true;
            }
            throw new ArrayIndexOutOfBoundsException("Nao achei");
        }
        return false;
    }

    public Boolean remove(String element) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null && vetor[i].equalsIgnoreCase(element)) {
                vetor[i] = null;
                return true;
            }
        }
        return false;
    }
}