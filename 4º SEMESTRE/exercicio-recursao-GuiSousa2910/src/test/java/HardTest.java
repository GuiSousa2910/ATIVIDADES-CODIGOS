import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HardTest {

    // =============================
    // Testes de fibonacci()
    // =============================

    @Test
    @DisplayName("fibonacci(0) deve retornar 0")
    public void testFibonacciZero() {
        assertEquals(0, Hard.fibonacci(0));
    }

    @Test
    @DisplayName("fibonacci(1) deve retornar 1")
    public void testFibonacciUm() {
        assertEquals(1, Hard.fibonacci(1));
    }

    @Test
    @DisplayName("fibonacci(2) deve retornar 1")
    public void testFibonacciDois() {
        assertEquals(1, Hard.fibonacci(2));
    }

    @Test
    @DisplayName("fibonacci(5) deve retornar 5")
    public void testFibonacciCinco() {
        assertEquals(5, Hard.fibonacci(5));
    }

    @Test
    @DisplayName("fibonacci(7) deve retornar 13")
    public void testFibonacciSete() {
        assertEquals(13, Hard.fibonacci(7));
    }

    @Test
    @DisplayName("fibonacci(10) deve retornar 55")
    public void testFibonacciDez() {
        assertEquals(55, Hard.fibonacci(10));
    }


    // =============================
    // Testes de sumDigits()
    // =============================

    @Test
    @DisplayName("sumDigits(123) deve retornar 6")
    public void testSumDigits123() {
        assertEquals(6, Hard.sumDigits(123));
    }

    @Test
    @DisplayName("sumDigits(405) deve retornar 9")
    public void testSumDigits405() {
        assertEquals(9, Hard.sumDigits(405));
    }

    @Test
    @DisplayName("sumDigits(0) deve retornar 0")
    public void testSumDigitsZero() {
        assertEquals(0, Hard.sumDigits(0));
    }

    @Test
    @DisplayName("sumDigits(9999) deve retornar 36")
    public void testSumDigits9999() {
        assertEquals(36, Hard.sumDigits(9999));
    }

    @Test
    @DisplayName("sumDigits(7) deve retornar o próprio número (7)")
    public void testSumDigitsUnico() {
        assertEquals(7, Hard.sumDigits(7));
    }
}
