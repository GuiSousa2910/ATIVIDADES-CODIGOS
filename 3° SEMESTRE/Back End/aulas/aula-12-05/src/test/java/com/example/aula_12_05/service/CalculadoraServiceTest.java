package com.example.aula_12_05.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    @DisplayName("Somar quando for acionado com valores 2.0 e 2.0 deve retornar 4.0")
    void somarQuandoAcionadoComValoresValidosDeveRetornarCorretamenteTest() {
        var input1 = 2.0;
        var input2 = 2.0;
        var resultadoEsperado = 4.0;
        CalculadoraService calculadoraService = new CalculadoraService();

        var resposta = calculadoraService.somar(input1, input2);

        assertEquals(resultadoEsperado, resposta);
    }

    @Test
    void somarComValoresValidosDeveRetornarCorretamenteTest() {
        var i1 = 10.0;
        var i2 = 10.0;
        var resultado = 20.0;

        CalculadoraService calculadoraService = new CalculadoraService();

        var resposta = calculadoraService.somar(i1, i2);
        assertEquals(resultado, resposta);
    }

    @Test
    @DisplayName("Somar quando acionado com um valor null deve lancar illegalArgumentException")
    void somarQuandoAcionadoComValorNullDeveLancarIllegalArgumentExceptionTest() {
        var inputValido = 2.0;
        Double inputNull = null;

        CalculadoraService calculadoraService = new CalculadoraService();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculadoraService.somar(inputValido, inputNull)
        );

        var texto = "Nao pode ser nulo";

        assertEquals(texto, exception.getMessage());
    }
}