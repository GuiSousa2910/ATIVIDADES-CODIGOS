import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MediumTest {

    // =============================
    // Testes de countOccurrences()
    // =============================

    @Test
    @DisplayName("countOccurrences('banana', 'a') deve retornar 3")
    public void testCountOccurrencesBasico() {
        assertEquals(3, Medium.countOccurrences("banana", 'a'));
    }

    @Test
    @DisplayName("countOccurrences('recursao', 'r') deve retornar 2")
    public void testCountOccurrencesComR() {
        assertEquals(2, Medium.countOccurrences("recursao", 'r'));
    }

    @Test
    @DisplayName("countOccurrences('mississippi', 's') deve retornar 4")
    public void testCountOccurrencesMultiplo() {
        assertEquals(4, Medium.countOccurrences("mississippi", 's'));
    }

    @Test
    @DisplayName("countOccurrences('hello', 'z') deve retornar 0 quando caractere não aparece")
    public void testCountOccurrencesZero() {
        assertEquals(0, Medium.countOccurrences("hello", 'z'));
    }

    @Test
    @DisplayName("countOccurrences em string vazia deve retornar 0")
    public void testCountOccurrencesVazia() {
        assertEquals(0, Medium.countOccurrences("", 'a'));
    }
}
