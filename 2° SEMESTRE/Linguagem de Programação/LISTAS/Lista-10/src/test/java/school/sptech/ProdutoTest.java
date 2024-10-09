package school.sptech;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import school.sptech.factory.ProdutoFactory;
import school.sptech.provider.produto.AumentarEstoqueProvider;
import school.sptech.provider.produto.CalcularImpostoProvider;
import school.sptech.provider.produto.ComprarProvider;
import school.sptech.provider.produto.DisponivelParaCompraProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Produto")
class ProdutoTest {

    @Nested
    @DisplayName("1. Atributos")
    class AtributosTest {

        @Test
        @DisplayName("1. Validar Atributos")
        void test1() {
            Class<Produto> clazz = Produto.class;

            assertAll(
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredField("nome")),
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredField("precoUnitario")),
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredField("peso")),
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredField("quantidadeDisponivel"))
            );
        }
    }

    @Nested
    @DisplayName("2. Métodos")
    class MetodosTest {

        @Test
        @DisplayName("1. Validar Métodos")
        void test1() {
            Class<Produto> clazz = Produto.class;

            assertAll(
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("calcularImposto")),
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("disponivelParaCompra", LocalDate.class)),
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("comprar", Integer.class)),
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("aumentarEstoque", Integer.class))
            );
        }
    }

    @Nested
    @DisplayName("3. Encapsulamento")
    class EncapsulamentoTest {

        @Test
        @DisplayName("1. Atributos Privados")
        void test1() {
            Class<Produto> clazz = Produto.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                    .map(campo -> () -> assertTrue(Modifier.isPrivate(campo.getModifiers())));

            assertAll(validacoes);
        }

        @Test
        @DisplayName("2. Métodos Públicos")
        void test2() {
            Class<Produto> clazz = Produto.class;

            List<Method> metodos = new ArrayList<>();

            try {
                metodos.add(clazz.getDeclaredMethod("calcularImposto"));
            } catch (ReflectiveOperationException ignored) {
            }

            try {
                metodos.add(clazz.getDeclaredMethod("disponivelParaCompra", LocalDate.class));
            } catch (ReflectiveOperationException ignored) {
            }

            try {
                metodos.add(clazz.getDeclaredMethod("comprar", Integer.class));
            } catch (ReflectiveOperationException ignored) {
            }

            try {
                metodos.add(clazz.getDeclaredMethod("aumentarEstoque", Integer.class));
            } catch (ReflectiveOperationException ignored) {
            }

            Stream<Executable> validacoes = metodos.stream()
                    .map((metodo) -> () -> {
                        assertTrue(Modifier.isPublic(metodo.getModifiers()));
                    });

            assertAll(validacoes);
        }

        @Test
        @DisplayName("3. Atributos devem possuir getters e setters")
        void test3() {
            Class<Produto> clazz = Produto.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoesGetter = Arrays.stream(campos)
                    .map(campo -> () -> {
                        String getName = String.format("get%s", StringUtils.capitalize(campo.getName()));
                        assertDoesNotThrow(() -> {
                            Method getter = clazz.getDeclaredMethod(getName);
                            int getModifier = getter.getModifiers();
                            assertTrue(Modifier.isPublic(getModifier));
                        });
                    });

            Stream<Executable> validacoesSetter = Arrays.stream(campos)
                    .map(campo -> () -> {
                        String setName = String.format("set%s", StringUtils.capitalize(campo.getName()));
                        assertDoesNotThrow(() -> {
                            Method setter = clazz.getDeclaredMethod(setName, campo.getType());
                            int setModifier = setter.getModifiers();
                            assertTrue(Modifier.isPublic(setModifier));
                        });
                    });

            assertAll(Stream.concat(validacoesGetter, validacoesSetter));
        }
    }

    @Nested
    @DisplayName("4. Métodos - calcularImposto")
    class CalcularImpostoTest {

        @ParameterizedTest
        @ArgumentsSource(CalcularImpostoProvider.class)
        @DisplayName("1. Deve retornar 2% do preço unitário")
        void test1(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, Double expected) throws ReflectiveOperationException {

            Class<Produto> clazz = Produto.class;
            Method method = clazz.getDeclaredMethod("calcularImposto");

            // Case
            Object obj = ProdutoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel);

            // When
            Double result = (Double) method.invoke(obj);

            // Then
            assertEquals(expected, result, 0.01);
        }
    }

    @Nested
    @DisplayName("5. Métodos - disponivelParaCompra")
    class DisponivelParaCompraTest {

        @ParameterizedTest
        @ArgumentsSource(DisponivelParaCompraProvider.class)
        @DisplayName("1. Deve retornar true se a quantidade disponível for maior que 0")
        void test1(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, Boolean expected) throws ReflectiveOperationException {

            Class<Produto> clazz = Produto.class;
            Method method = clazz.getDeclaredMethod("disponivelParaCompra", LocalDate.class);

            // Given
            Object obj = ProdutoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel);

            // When
            Boolean result = (Boolean) method.invoke(obj, LocalDate.parse("2024-10-01"));

            // Then
            assertEquals(expected, result, "Deve retornar true se a quantidade disponível for maior que 0");
        }
    }

    @Nested
    @DisplayName("6. Métodos - comprar")
    class ComprarTest {

        @ParameterizedTest
        @ArgumentsSource(ComprarProvider.ValorValido.class)
        @DisplayName("1. Deve decrementar a quantidade disponível")
        void test1(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, Integer unidades, Integer expected) throws ReflectiveOperationException {
            Class<Produto> clazz = Produto.class;
            Method method = clazz.getDeclaredMethod("comprar", Integer.class);
            Field field = clazz.getDeclaredField("quantidadeDisponivel");
            field.setAccessible(true);

            // Given
            Object obj = ProdutoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel);

            // When
            method.invoke(obj, unidades);

            // Then
            assertEquals(expected, field.get(obj));
        }

        @ParameterizedTest
        @ArgumentsSource(ComprarProvider.ValorInvalido.class)
        @DisplayName("2. Nao deve realizar a compra se a quantidade disponível for menor que a quantidade a ser comprada")
        void test2(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, Integer unidades, Integer expected) throws ReflectiveOperationException {
            Class<Produto> clazz = Produto.class;
            Method method = clazz.getDeclaredMethod("comprar", Integer.class);
            Field field = clazz.getDeclaredField("quantidadeDisponivel");
            field.setAccessible(true);

            // Given
            Object obj = ProdutoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel);

            // When
            method.invoke(obj, unidades);

            // Then
            assertEquals(expected, field.get(obj));
        }

        @ParameterizedTest
        @ArgumentsSource(ComprarProvider.ValorNegativo.class)
        @DisplayName("3. Nao deve realizar a compra se a quantidade a ser comprada for negativa")
        void test3(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, Integer unidades, Integer expected) throws ReflectiveOperationException {
            Class<Produto> clazz = Produto.class;
            Method method = clazz.getDeclaredMethod("comprar", Integer.class);
            Field field = clazz.getDeclaredField("quantidadeDisponivel");
            field.setAccessible(true);

            // Given
            Object obj = ProdutoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel);

            // When
            method.invoke(obj, unidades);

            // Then
            assertEquals(expected, field.get(obj));
        }
    }

    @Nested
    @DisplayName("7. Métodos - aumentarEstoque")
    class AumentarEstoqueTest {

        @ParameterizedTest
        @ArgumentsSource(AumentarEstoqueProvider.ValorValido.class)
        @DisplayName("1. Deve incrementar a quantidade disponível")
        void test1(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, Integer unidades, Integer expected) throws ReflectiveOperationException {
            Class<Produto> clazz = Produto.class;
            Method method = clazz.getDeclaredMethod("aumentarEstoque", Integer.class);
            Field field = clazz.getDeclaredField("quantidadeDisponivel");
            field.setAccessible(true);

            // Given
            Object obj = ProdutoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel);

            // When
            method.invoke(obj, unidades);

            // Then
            assertEquals(expected, field.get(obj));
        }

        @ParameterizedTest
        @ArgumentsSource(AumentarEstoqueProvider.ValorNegativo.class)
        @DisplayName("2. Não deve realizar a compra se a quantidade a ser incrementada for negativa")
        void test2(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, Integer unidades, Integer expected) throws ReflectiveOperationException {
            Class<Produto> clazz = Produto.class;
            Method method = clazz.getDeclaredMethod("aumentarEstoque", Integer.class);
            Field field = clazz.getDeclaredField("quantidadeDisponivel");
            field.setAccessible(true);

            // Given
            Object obj = ProdutoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel);

            // When
            method.invoke(obj, unidades);

            // Then
            assertEquals(expected, field.get(obj));
        }
    }
}
