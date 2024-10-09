package school.sptech;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import school.sptech.factory.AlimentoFactory;
import school.sptech.provider.alimento.CalcularImpostoProvider;
import school.sptech.provider.alimento.DisponivelParaCompraProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Alimento")
public class AlimentoTest {

    @Nested
    @DisplayName("1. Atributos")
    class AtributosTest {

        @Test
        @DisplayName("1. Validar Atributos")
        void test1() {
            Class<Alimento> clazz = Alimento.class;

            assertAll(
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredField("prazoValidade"))
            );
        }
    }

    @Nested
    @DisplayName("2. Métodos")
    class MetodosTest {

        @Test
        @DisplayName("1. Validar Métodos")
        void test1() {
            Class<Alimento> clazz = Alimento.class;

            assertAll(
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("calcularImposto")),
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("disponivelParaCompra", LocalDate.class))
            );
        }
    }

    @Nested
    @DisplayName("3. Encapsulamento")
    class EncapsulamentoTest {

        @Test
        @DisplayName("1. Atributos Privados")
        void test1() {
            Class<Alimento> clazz = Alimento.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                    .map(campo -> () -> assertTrue(Modifier.isPrivate(campo.getModifiers())));

            assertAll(validacoes);
        }

        @Test
        @DisplayName("2. Métodos Públicos")
        void test2() {
            Class<Alimento> clazz = Alimento.class;

            List<Method> metodos = new ArrayList<>();

            try {
                metodos.add(clazz.getDeclaredMethod("calcularImposto"));
            } catch (ReflectiveOperationException ignored) {
            }

            try {
                metodos.add(clazz.getDeclaredMethod("disponivelParaCompra", LocalDate.class));
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
            Class<Alimento> clazz = Alimento.class;
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
    @DisplayName("4. Herança")
    class HerancaTests {

        @Test
        @DisplayName("1. Alimento de ser uma subclasse de Produto")
        void test1() {
            Assertions.assertTrue(Produto.class.isAssignableFrom(Alimento.class));
        }
    }

    @Nested
    @DisplayName("5. Métodos - calcularImposto")
    class CalcularImpostoTest {

        @ParameterizedTest
        @ArgumentsSource(CalcularImpostoProvider.class)
        @DisplayName("1. Deve retornar 3% do preço unitário")
        void test1(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, LocalDate prazoValidade, Double expected) throws ReflectiveOperationException {

            Class<Alimento> clazz = Alimento.class;
            Method method = clazz.getDeclaredMethod("calcularImposto");

            // Case
            Object obj = AlimentoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel, prazoValidade);

            // When
            Double result = (Double) method.invoke(obj);

            // Then
            assertEquals(expected, result, 0.01);
        }
    }

    @Nested
    @DisplayName("6. Métodos - disponivelParaCompra")
    class DisponivelParaCompraTest {

        @ParameterizedTest
        @ArgumentsSource(DisponivelParaCompraProvider.class)
        @DisplayName("1. Deve retornar true se a quantidade disponível for maior que 0 e estiver dentro do prazo de validade")
        void test1(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, LocalDate prazoValidade, Boolean expected) throws ReflectiveOperationException {

            Class<Alimento> clazz = Alimento.class;
            Method method = clazz.getDeclaredMethod("disponivelParaCompra", LocalDate.class);

            // Given
            Object obj = AlimentoFactory.build(nome, precoUnitario, peso, quantidadeDisponivel, prazoValidade);

            // When
            Boolean result = (Boolean) method.invoke(obj, LocalDate.parse("2024-10-01"));

            // Then
            assertEquals(expected, result);
        }
    }
}
