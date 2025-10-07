package github.britooo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ListaConsultaTest {

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

    // --------------- contains ----------------

    @Test
    @DisplayName("contains: true quando elemento existe; suporta null")
    void contains_funciona() {
        var lista = new Lista<String>();
        preload(lista, 5, new String[]{"A", null, "B", "C", null}, 4);

        assertTrue(lista.contains("A"));
        assertTrue(lista.contains(null));
        assertFalse(lista.contains("X"));
    }

    // --------------- indexOf ----------------

    @Test
    @DisplayName("indexOf: retorna o índice da primeira ocorrência ou -1")
    void indexOf_primeiraOcorrencia() {
        var lista = new Lista<String>();
        preload(lista, 6, new String[]{"X", "Y", "Z", "Y", "X", null}, 6);

        assertEquals(0, lista.indexOf("X"));
        assertEquals(1, lista.indexOf("Y"));
        assertEquals(-1, lista.indexOf("W"));
        assertEquals(5, lista.indexOf(null)); // se null estiver na 5, mas aqui used=5, então não
    }

    @Test
    @DisplayName("indexOf: com null presente retorna o índice correto")
    void indexOf_nullFunciona() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A", null, "B", null}, 4);

        assertEquals(1, lista.indexOf(null));
    }

    // --------------- lastIndexOf ----------------

    @Test
    @DisplayName("lastIndexOf: retorna o índice da última ocorrência ou -1")
    void lastIndexOf_ultimaOcorrencia() {
        var lista = new Lista<String>();
        preload(lista, 6, new String[]{"X", "Y", "Z", "Y", "X", null}, 5);

        assertEquals(4, lista.lastIndexOf("X"));
        assertEquals(3, lista.lastIndexOf("Y"));
        assertEquals(-1, lista.lastIndexOf("W"));
    }

    @Test
    @DisplayName("lastIndexOf: com null presente retorna o último índice de null")
    void lastIndexOf_nullFunciona() {
        var lista = new Lista<String>();
        preload(lista, 6, new String[]{"A", null, "B", null, "C", null}, 6);

        assertEquals(5, lista.lastIndexOf(null));
    }
}
