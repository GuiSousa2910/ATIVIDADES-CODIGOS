package github.britooo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ListaRemocaoTest {

    // Helpers reflection
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

    // ---------------- remove(index) ----------------

    @Test
    @DisplayName("remove(index): remove do meio e puxa elementos para trás, retornando o valor removido")
    void removeIndex_removeDoMeio() {
        var lista = new Lista<String>();
        preload(lista, 6, new String[]{"A","B","C","D","E",null}, 5);

        String removed = lista.remove(2); // remove "C"
        assertEquals("C", removed);
        var a = elements(lista);
        assertEquals(4, numElements(lista));
        assertEquals("A", a[0]);
        assertEquals("B", a[1]);
        assertEquals("D", a[2]);
        assertEquals("E", a[3]);
    }

    @Test
    @DisplayName("remove(index): remove do fim corretamente")
    void removeIndex_removeDoFim() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A","B","C","D"}, 4);

        String removed = lista.remove(3);
        assertEquals("D", removed);
        assertEquals(3, numElements(lista));
    }

    @Test
    @DisplayName("remove(index): index inválido -> lança exceção")
    void removeIndex_invalido_lancaExcecao() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A","B",null,null}, 2);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(2));
    }

    // ---------------- remove(element) ----------------

    @Test
    @DisplayName("remove(element): remove primeira ocorrência existente e retorna true")
    void removeElement_removePrimeiraOcorrencia() {
        var lista = new Lista<String>();
        preload(lista, 6, new String[]{"X","Y","Z","Y",null,null}, 4);

        assertTrue(lista.remove("Y"));
        assertEquals(3, numElements(lista));
        var a = elements(lista);
        assertEquals("X", a[0]);
        assertEquals("Z", a[1]); // Y da posição 1 foi removido
        assertEquals("Y", a[2]); // a segunda ocorrência “anda” para trás
    }

    @Test
    @DisplayName("remove(element): elemento inexistente retorna false (lista inalterada)")
    void removeElement_inexistente_false() {
        var lista = new Lista<String>();
        preload(lista, 4, new String[]{"A","B","C",null}, 3);

        assertFalse(lista.remove("X"));
        assertEquals(3, numElements(lista));
    }

    @Test
    @DisplayName("remove(element): aceita null (remove primeira ocorrência de null)")
    void removeElement_aceitaNull() {
        var lista = new Lista<String>();
        preload(lista, 5, new String[]{"A", null, "B", null, null}, 4);

        assertTrue(lista.remove(null));
        assertEquals(3, numElements(lista));
    }

    // ---------------- clear ----------------

    @Test
    @DisplayName("clear: zera size mas mantém capacidade")
    void clear_zeraSize_mantemCapacidade() {
        var lista = new Lista<String>();
        preload(lista, 8, new String[]{"A","B","C","D","E","F","G","H"}, 8);
        int capAntes = elements(lista).length;

        lista.clear();

        assertEquals(0, numElements(lista));
        assertEquals(capAntes, elements(lista).length, "Capacidade deve ser mantida");
    }
}
