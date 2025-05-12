package com.example.aula_12_05.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    @Test
    void isPalindromeQuandoAcionadoComTextoAraraDeveRetornarTrue(){
        var text = "arara";
        Atividade atividade = new Atividade();

        boolean result = atividade.isPalindrome(text);

        assertTrue(result);
    }
}