package school.sptech;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import school.sptech.factory.LivroFactory;
import school.sptech.providers.livro.AdicionarAvaliacaoInvalidaProvider;
import school.sptech.providers.livro.AdicionarAvaliacaoProvider;
import school.sptech.providers.livro.CalcularMediaAvaliacoesProvider;

@DisplayName("Livro")
public class LivroTest {

    @Nested
    @DisplayName("1. Atributos")
    class AtributosTest {

        @Test
        @DisplayName("1. Validar atributos")
        void validarAtributos() {
            Class<Livro> clazz = Livro.class;

            assertAll(
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("autor")),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("titulo")),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("dataPublicacao")),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("avaliacoes"))
            );
        }
    }

    @Nested
    @DisplayName("2. Métodos")
    class MetodoTest {

        @Test
        @DisplayName("1. Validar métodos")
        void validarMetodos() {
            Class<Livro> clazz = Livro.class;

            assertAll(
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("adicionarAvaliacao", String.class, Double.class))
            );
        }
    }

    @Nested
    @DisplayName("3. Encapsulamento")
    class EncapsulamentoTest {

        @Test
        @DisplayName("1. Atributos Privados")
        void validarEncapsulamento() {
            Class<Livro> clazz = Livro.class;

            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                  .map(campo -> () -> assertTrue(Modifier.isPrivate(campo.getModifiers())));

            assertAll(validacoes);
        }

        @Test
        @DisplayName("2. Métodos Públicos")
        void validarMetodosPublicos() {
            Class<Livro> clazz = Livro.class;
            List<Method> metodos = new ArrayList<>();

            try {
                metodos.add(clazz.getDeclaredMethod("adicionarAvaliacao", String.class, Integer.class));
            } catch (ReflectiveOperationException ignored) {}

            Stream<Executable> validacoes = metodos.stream()
                  .map((metodo) -> () -> {
                      assertTrue(Modifier.isPublic(metodo.getModifiers()));
                  });

            assertAll(validacoes);
        }

        @Test
        @DisplayName("3. Atributos devem possuir getters e setters")
        void test3() {
            Class<Livro> clazz = Livro.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoesGetter = Arrays.stream(campos)
                  .map(campo -> () -> {
                      String getName = String.format("get%s",
                            StringUtils.capitalize(campo.getName()));
                      assertDoesNotThrow(() -> {
                          Method getter = clazz.getDeclaredMethod(getName);
                          int getModifier = getter.getModifiers();
                          assertTrue(Modifier.isPublic(getModifier));
                      });
                  });

            Stream<Executable> validacoesSetter = Arrays.stream(campos)
                  .map(campo -> () -> {
                      String setName = String.format("set%s",
                            StringUtils.capitalize(campo.getName()));
                      assertDoesNotThrow(() -> {
                          Method setter = clazz.getDeclaredMethod(setName, campo.getType());
                          int setModifier = setter.getModifiers();
                          assertTrue(Modifier.isPublic(setModifier));
                      });
                  });

            assertAll(Stream.concat(validacoesGetter, validacoesSetter));
        }

        @Test
        @DisplayName("4. Lista de avaliações ao criar o objeto não pode ser nula")
        void test4() throws ReflectiveOperationException {
            Class<Livro> clazz = Livro.class;
            Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
            Object[] parameters = Arrays.stream(constructor.getParameters()).map(param -> null).toArray();

            Object livro = constructor.newInstance(parameters);

            Field campoAvaliacoes = clazz.getDeclaredField("avaliacoes");
            campoAvaliacoes.trySetAccessible();

            assertNotNull(campoAvaliacoes.get(livro));
        }
    }

    @Nested
    @DisplayName("4. Adicionar Avaliação")
    class AdicionarAvaliacaoTest {

        @ParameterizedTest
        @ArgumentsSource(AdicionarAvaliacaoProvider.class)
        @DisplayName("1. Avaliações válidas")
        void test1(String titulo, String autor, LocalDate dataPublicacao, List<?> avaliacoes, String descricao,
                   Double qtdEstrelas, List<?> expected) throws ReflectiveOperationException {

            Class<Livro> clazz = Livro.class;
            Method method = clazz.getDeclaredMethod("adicionarAvaliacao", String.class, Double.class);

            Object obj = LivroFactory.build(titulo, autor, dataPublicacao, new ArrayList<>(avaliacoes));
            method.invoke(obj, descricao, qtdEstrelas);

            Field field = clazz.getDeclaredField("avaliacoes");
            field.setAccessible(true);

            ArrayList<?> result = (ArrayList<?>) field.get(obj);

            Iterator<?> expectedIterator = expected.iterator();
            Iterator<?> actualIterator = result.iterator();

            assertEquals(expected.size(), result.size());

            Class<Avaliacao> avaliacaoClass = Avaliacao.class;
            Field campoDescricao = avaliacaoClass.getDeclaredField("descricao");
            campoDescricao.trySetAccessible();

            Field campoQtdEstrelas = avaliacaoClass.getDeclaredField("qtdEstrelas");
            campoQtdEstrelas.trySetAccessible();

            ArrayList<Executable> executables = new ArrayList<>();

            while(expectedIterator.hasNext() && actualIterator.hasNext()) {
                Object expectedElement = expectedIterator.next();
                Object actualElement = actualIterator.next();

                executables.add(() -> assertEquals(campoDescricao.get(expectedElement), campoDescricao.get(actualElement)));
                executables.add(() -> assertEquals(campoQtdEstrelas.get(expectedElement), campoQtdEstrelas.get(actualElement)));
            }

            assertAll(executables);
        }

        @ParameterizedTest
        @ArgumentsSource(AdicionarAvaliacaoInvalidaProvider.class)
        @DisplayName("2. Avaliações inválidas")
        void test2(String titulo, String autor, LocalDate dataPublicacao, List<?> avaliacoes, String descricao,
                   Double qtdEstrelas, List<?> expected) throws ReflectiveOperationException {

            Class<Livro> clazz = Livro.class;
            Method method = clazz.getDeclaredMethod("adicionarAvaliacao", String.class, Double.class);

            Object obj = LivroFactory.build(titulo, autor, dataPublicacao, new ArrayList<>(avaliacoes));
            method.invoke(obj, descricao, qtdEstrelas);

            Field field = clazz.getDeclaredField("avaliacoes");
            field.setAccessible(true);

            ArrayList<?> result = (ArrayList<?>) field.get(obj);

            Iterator<?> expectedIterator = expected.iterator();
            Iterator<?> actualIterator = result.iterator();

            assertEquals(expected.size(), result.size());

            Class<Avaliacao> avaliacaoClass = Avaliacao.class;
            Field campoDescricao = avaliacaoClass.getDeclaredField("descricao");
            campoDescricao.trySetAccessible();

            Field campoQtdEstrelas = avaliacaoClass.getDeclaredField("qtdEstrelas");
            campoQtdEstrelas.trySetAccessible();

            ArrayList<Executable> executables = new ArrayList<>();

            while(expectedIterator.hasNext() && actualIterator.hasNext()) {
                Object expectedElement = expectedIterator.next();
                Object actualElement = actualIterator.next();

                executables.add(() -> assertEquals(campoDescricao.get(expectedElement), campoDescricao.get(actualElement)));
                executables.add(() -> assertEquals(campoQtdEstrelas.get(expectedElement), campoQtdEstrelas.get(actualElement)));
            }

            assertAll(executables);
        }
    }

    @Nested
    @DisplayName("5. Calcular Média Avaliações")
    class CalcularMediaAvaliacoesTest {

        @ParameterizedTest
        @ArgumentsSource(CalcularMediaAvaliacoesProvider.class)
        @DisplayName("1. Deve calcular a média das avaliações")
        void test1(String titulo, String autor, LocalDate dataPublicacao, List<Avaliacao> avaliacoes, Double expected) throws ReflectiveOperationException {
            Class<Livro> clazz = Livro.class;
            Method method = clazz.getDeclaredMethod("calcularMediaAvaliacoes");

            Object obj = LivroFactory.build(titulo, autor, dataPublicacao, new ArrayList<>(avaliacoes));

            Double result = (Double) method.invoke(obj);

            assertEquals(expected, result, 0.01);
        }
    }

    @Nested
    @DisplayName("6. toString")
    class ValidarToStringTest {

        @Test
        @DisplayName("1. Deve possuir o método toString")
        void validarToString() {
            Class<Livro> clazz = Livro.class;
            assertAll(
                    () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("toString"))
            );
        }
    }
}


