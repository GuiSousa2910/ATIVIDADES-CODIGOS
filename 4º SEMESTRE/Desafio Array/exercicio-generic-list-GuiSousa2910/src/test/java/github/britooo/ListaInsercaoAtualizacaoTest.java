package github.britooo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ListaInsercaoAtualizacaoTest {

    // ------------ Helpers (reflection) ------------
    @SuppressWarnings("unchecked")
    private static Object[] elements(Lista<?> lista) {
        try {
            Field f = Lista.class.getDeclaredField("elements");
            f.setAccessible(true);
            return (Object[]) f.get(lista);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int numElements(Lista<?> lista) {
        try {
            Field f = Lista.class.getDeclaredField("numElements");
            f.setAccessible(true);
            return (int) f.get(lista);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void preload(Lista<String> lista, int capacity, String[] values, int used) {
        try {
            Field arr = Lista.class.getDeclaredField("elements");
            Field n = Lista.class.getDeclaredField("numElements");
            arr.setAccessible(true);
            n.setAccessible(true);
            Object[] backing = new Object[Math.max(capacity, 4)];
            if (values != null) {
                System.arraycopy(values, 0, backing, 0, values.length);
            }
            arr.set(lista, backing);
            n.set(lista, used);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- add(T) -------------------

    @Test
    @DisplayName("add: insere no final quando há espaço -> numElements incrementa e valor no último índice")
    void add_insereNoFinal_quandoHaEspaco() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A", "B", null, null}, 2);

        assertTrue(lista.add("C"), "add deve retornar true");
        assertEquals(3, numElements(lista), "numElements deve ser 3");
        assertEquals("C", elements(lista)[2]);
    }

    @Test
    @DisplayName("add: faz resize ao inserir 5º elemento (cap 4 -> 8) e preserva ordem")
    void add_fazResizeCapacidadeDobraEPreservaOrdem() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A", "B", "C", "D"}, 4);

        assertTrue(lista.add("E"));
        var novo = elements(lista);
        assertEquals(8, novo.length, "Capacidade deve dobrar para 8");
        assertEquals(5, numElements(lista));
        assertEquals("A", novo[0]); assertEquals("B", novo[1]);
        assertEquals("C", novo[2]); assertEquals("D", novo[3]);
        assertEquals("E", novo[4]);
    }

    @Test
    @DisplayName("add: aceita null como elemento e armazena corretamente")
    void add_aceitaNull() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"X", null, null, null}, 1);

        assertTrue(lista.add(null));
        assertEquals(2, numElements(lista));
        assertNull(elements(lista)[1], "Deve armazenar null no índice 1");
    }

    // --------------- add(int, T) ------------------

    @Test
    @DisplayName("add(index): insere no meio e desloca elementos à direita")
    void addIndex_insereNoMeio_deslocaParaDireita() {
        var lista = new Lista<String>();
        preload(lista, 6, new String[]{"A", "B", "D", "E", null, null}, 4);

        assertTrue(lista.add(2, "C"));
        var a = elements(lista);
        assertEquals(5, numElements(lista));
        assertEquals("A", a[0]);
        assertEquals("B", a[1]);
        assertEquals("C", a[2]);
        assertEquals("D", a[3]);
        assertEquals("E", a[4]);
    }

    @Test
    @DisplayName("add(index): index == size (insere no fim) sem depender do add simples")
    void addIndex_insereNoFim_quandoIndexIgualTamanho() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A", null, null, null}, 1);

        assertTrue(lista.add(1, "B"));
        assertEquals(2, numElements(lista));
        assertEquals("B", elements(lista)[1]);
    }

    @Test
    @DisplayName("add(index): index inválido (<0 ou >size) -> lança exceção")
    void addIndex_invalido_lancaExcecao() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{null, null, null, null}, 0);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.add(-1, "X"));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.add(1, "X"));
    }

    // ---------------- addAll(Lista<T>) ----------------

    @Test
    @DisplayName("addAll: insere todos de outra lista e retorna true quando origem não-vazia")
    void addAll_insereTodos_quandoOrigemNaoVazia() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{null, null, null, null}, 0);

        var origem = new Lista<String>();
        preload(origem, 4, new String[]{"A", "B", null, null}, 2);

        assertTrue(lista.addAll(origem));
        assertEquals(2, numElements(lista));
        assertEquals("A", elements(lista)[0]);
        assertEquals("B", elements(lista)[1]);
    }

    @Test
    @DisplayName("addAll: retorna false quando origem está vazia (nada inserido)")
    void addAll_origemVazia_retornaFalse() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{null, null, null, null}, 0);

        var origemVazia = new Lista<String>();
        preload(origemVazia, 4, new String[]{null, null, null, null}, 0);

        assertFalse(lista.addAll(origemVazia));
        assertEquals(0, numElements(lista));
    }

    @Test
    @DisplayName("addAll: realiza múltiplos resizes se necessário e mantém ordem")
    void addAll_variosResizes_mantemOrdem() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"X", null, null, null}, 1);

        var origem = new Lista<String>();
        preload(origem, 7, new String[]{"A","B","C","D","E","F","G"}, 7);

        assertTrue(lista.addAll(origem));

        var arrFinal = elements(lista);
        assertTrue(arrFinal.length >= 8, "Capacidade deve ter aumentado pelo menos uma vez");
        assertEquals(8, numElements(lista));
        assertEquals("X", arrFinal[0]);
        assertEquals("A", arrFinal[1]);
        assertEquals("G", arrFinal[7]);
    }

    // -------------------- set ----------------------

    @Test
    @DisplayName("set: substitui valor e retorna o antigo")
    void set_substituiERetornaAntigo() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A", "B", null, null}, 2);

        String old = lista.set(1, "BB");
        assertEquals("B", old);
        assertEquals("BB", elements(lista)[1]);
        assertEquals(2, numElements(lista), "set não altera size");
    }

    @Test
    @DisplayName("set: aceita null e mantém tamanho inalterado")
    void set_aceitaNull() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A", null, null, null}, 1);

        String old = lista.set(0, null);
        assertEquals("A", old);
        assertNull(elements(lista)[0]);
        assertEquals(1, numElements(lista));
    }

    @Test
    @DisplayName("set: index inválido (<0 ou >=size) -> lança exceção")
    void set_invalido_lancaExcecao() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{null, null, null, null}, 0);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(0, "X"));
        preload(lista, 4, new String[]{"A", "B", null, null}, 2);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(2, "X"));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(-1, "X"));
    }
}
