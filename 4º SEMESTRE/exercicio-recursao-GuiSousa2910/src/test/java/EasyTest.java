import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EasyTest {

    // =============================
    // Testes de fatorial()
    // =============================

    @Test
    @DisplayName("fatorial(0) deve retornar 1")
    public void testFatorialZero() {
        assertEquals(1, Easy.fatorial(0));
    }

    @Test
    @DisplayName("fatorial(1) deve retornar 1")
    public void testFatorialUm() {
        assertEquals(1, Easy.fatorial(1));
    }

    @Test
    @DisplayName("fatorial(5) deve retornar 120")
    public void testFatorialCinco() {
        assertEquals(120, Easy.fatorial(5));
    }

    @Test
    @DisplayName("fatorial(7) deve retornar 5040")
    public void testFatorialSete() {
        assertEquals(5040, Easy.fatorial(7));
    }

    @Test
    @DisplayName("fatorial(10) deve retornar 3.628.800")
    public void testFatorialDez() {
        assertEquals(3628800, Easy.fatorial(10));
    }

    // ==========================
    // Testes de soma(int n)
    // ==========================

    @Test
    @DisplayName("soma(1) deve retornar 1 (caso base)")
    public void testSomaCasoBase() {
        assertEquals(1, Easy.soma(1), "soma(1) deve retornar 1");
    }

    @Test
    @DisplayName("soma(5) deve retornar 15 (1+2+3+4+5)")
    public void testSomaCinco() {
        assertEquals(15, Easy.soma(5), "soma(5) deve retornar 15");
    }

    @Test
    @DisplayName("soma(10) deve retornar 55")
    public void testSomaDez() {
        assertEquals(55, Easy.soma(10), "soma(10) deve retornar 55");
    }

    @Test
    @DisplayName("soma(0) deve retornar 0")
    public void testSomaZero() {
        assertEquals(0, Easy.soma(0), "soma(0) deve retornar 0");
    }

    // ==========================
    // Testes de contagem(int n)
    // ==========================

    @Test
    @DisplayName("contagem(3) deve imprimir '3 2 1 ' na saída")
    public void testContagemTres() {
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        Easy.contagem(3);

        String output = saida.toString().trim();
        assertEquals("3 2 1", output, "contagem(3) deve imprimir 3 2 1");
    }

    @Test
    @DisplayName("contagem(5) deve imprimir '5 4 3 2 1 ' na saída")
    public void testContagemCinco() {
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        Easy.contagem(5);

        String output = saida.toString().trim();
        assertEquals("5 4 3 2 1", output, "contagem(5) deve imprimir 5 4 3 2 1");
    }

    @Test
    @DisplayName("contagem(0) não deve imprimir nada")
    public void testContagemZero() {
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        Easy.contagem(0);

        String output = saida.toString().trim();
        assertEquals("", output, "contagem(0) não deve imprimir nada");
    }
}
