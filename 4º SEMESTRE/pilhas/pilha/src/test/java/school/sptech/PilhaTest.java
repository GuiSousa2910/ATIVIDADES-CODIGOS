package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para Pilha<E> baseada em vetor")
class PilhaTest {

    @Test
    @DisplayName("Push seguido de peek deve retornar o último elemento (LIFO)")
    void pushPeekRetornaTopo() {
        Pilha<String> p = new Pilha<>(4);
        p.push("A");
        p.push("B");
        p.push("C");
        assertEquals("C", p.peek());
        p.push("D");
        assertEquals("D", p.peek());
    }

    @Test
    @DisplayName("Pop deve remover em ordem LIFO até esvaziar")
    void popEmOrdemLifo() {
        Pilha<Integer> p = new Pilha<>(3);
        p.push(10);
        p.push(20);
        p.push(30);

        assertEquals(30, p.pop());
        assertEquals(20, p.pop());
        assertEquals(10, p.pop());
        assertTrue(p.isEmpty(), "Após remover todos, a pilha deve estar vazia");
    }

    @Test
    @DisplayName("Peek em pilha vazia deve lançar EmptyStackException")
    void peekEmVaziaLancaEmptyStackException() {
        Pilha<Object> p = new Pilha<>(2);
        assertThrows(EmptyStackException.class, p::peek);
    }

    @Test
    @DisplayName("Pop em pilha vazia deve lançar EmptyStackException")
    void popEmVaziaLancaEmptyStackException() {
        Pilha<Object> p = new Pilha<>(1);
        assertThrows(EmptyStackException.class, p::pop);
    }

    @Test
    @DisplayName("Empilhar além da capacidade deve lançar StackOverflowError")
    void overflowLancaStackOverflowError() {
        Pilha<Integer> p = new Pilha<>(2);
        p.push(1);
        p.push(2);
        assertThrows(StackOverflowError.class, () -> p.push(3),
                "Ao exceder a capacidade, deve lançar StackOverflowError");
    }

    @Test
    @DisplayName("Clear deve esvaziar a pilha e permitir reutilização")
    void clearEReutilizacao() {
        Pilha<String> p = new Pilha<>(3);
        p.push("X");
        p.push("Y");
        p.clear();

        assertTrue(p.isEmpty(), "Após clear, isEmpty deve ser true");
        assertThrows(EmptyStackException.class, p::peek, "Após clear, peek deve falhar");

        // Reutiliza após clear
        p.push("A");
        p.push("B");
        assertEquals("B", p.peek());
        assertEquals("B", p.pop());
        assertEquals("A", p.pop());
        assertTrue(p.isEmpty());
    }

    @Test
    @DisplayName("Limite superior: preencher até o máximo e esvaziar completamente")
    void preencheAteCapacidadeEDesempilhaTudo() {
        Pilha<Integer> p = new Pilha<>(5);
        // Enche até a capacidade
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);

        // Ordem LIFO e sem exceções indevidas
        assertEquals(5, p.pop());
        assertEquals(4, p.pop());
        assertEquals(3, p.pop());
        assertEquals(2, p.pop());
        assertEquals(1, p.pop());
        assertTrue(p.isEmpty());
    }
}
