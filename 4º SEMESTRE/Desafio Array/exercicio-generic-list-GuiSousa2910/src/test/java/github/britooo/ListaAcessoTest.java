package github.britooo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ListaAcessoTest {

    // Helpers reflection
    private static void preload(Lista<String> lista, int capacity, String[] values, int used) {
        try {
            Field arr = Lista.class.getDeclaredField("elements");
            Field n = Lista.class.getDeclaredField("numElements");
            arr.setAccessible(true);
            n.setAccessible(true);
            Object[] backing = new Object[Math.max(capacity, 4)];
            if (values!=null) {
                System.arraycopy(values, 0, backing, 0, values.length);
            }
            arr.set(lista, backing);
            n.set(lista, used);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- get -------------------

    @Test
    @DisplayName("get: retorna elemento válido por índice")
    void get_retornaElemento() {
        var lista = new Lista<String>();
        preload(lista, 5, new String[]{"A", "B", "C", null, null}, 3);

        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
        assertEquals("C", lista.get(2));
    }

    @Test
    @DisplayName("get: aceita null armazenado")
    void get_aceitaNullArmazenado() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"X", null, null, null}, 2);
        assertNull(lista.get(1));
    }

    @Test
    @DisplayName("get: index inválido -> lança exceção")
    void get_invalido_lancaExcecao() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A", "B", null, null}, 2);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(2));
    }

    // ------------------- size / isEmpty -------------------

    @Test
    @DisplayName("size: reflete número de elementos (não a capacidade)")
    void size_refleteNumElements() {
        var lista = new Lista<String>();
        preload(lista, 8, new String[]{"A", "B", "C", "D", "E", "F", "G", "H"}, 8);
        assertEquals(8, lista.size());
    }

    @Test
    @DisplayName("isEmpty: true quando size == 0, false caso contrário")
    void isEmpty_funciona() {
        var vazia = new Lista<String>();
        preload(vazia, 4, new String[]{null, null, null, null}, 0);
        assertTrue(vazia.isEmpty());

        var cheia = new Lista<String>();
        preload(cheia, 4, new String[]{"A", null, null, null}, 1);
        assertFalse(cheia.isEmpty());
    }
}
