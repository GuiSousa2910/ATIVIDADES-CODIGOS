package github.britooo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InverterTextoStackTest {

    @Test
    @DisplayName("Quando receber 'Java' deve retornar 'avaJ'")
    void deveInverterPalavraSimples() {
        assertEquals("avaJ", InverterTextoStack.inverter("Java"));
    }

    @Test
    @DisplayName("Quando receber números '12345' deve retornar '54321'")
    void deveInverterNumeros() {
        assertEquals("54321", InverterTextoStack.inverter("12345"));
    }

    @Test
    @DisplayName("Quando receber 'olá mundo' deve retornar 'odnum álo'")
    void deveInverterFraseComEspacos() {
        assertEquals("odnum álo", InverterTextoStack.inverter("olá mundo"));
    }

    @Test
    @DisplayName("Quando receber 'abc#@!' deve retornar '!@#cba'")
    void deveInverterTextoComCaracteresEspeciais() {
        assertEquals("!@#cba", InverterTextoStack.inverter("abc#@!"));
    }

    @Test
    @DisplayName("Quando receber string vazia deve retornar string vazia")
    void deveRetornarVazioParaStringVazia() {
        assertEquals("", InverterTextoStack.inverter(""));
    }

    @Test
    @DisplayName("Quando receber apenas um caractere deve retornar o mesmo caractere")
    void deveRetornarMesmoCaractereSeUmSo() {
        assertEquals("X", InverterTextoStack.inverter("X"));
    }

    @Test
    @DisplayName("Quando receber apenas espaços deve manter os espaços invertidos")
    void deveManterEspacosSeSomenteEspacos() {
        assertEquals("   ", InverterTextoStack.inverter("   "));
    }
}
