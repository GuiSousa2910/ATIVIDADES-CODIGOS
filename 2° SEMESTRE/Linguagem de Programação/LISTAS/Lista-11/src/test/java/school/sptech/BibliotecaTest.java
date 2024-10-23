package school.sptech;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import school.sptech.factory.BibliotecaFactory;
import school.sptech.providers.biblioteca.AdicionarLivroInvalidoProvider;
import school.sptech.providers.biblioteca.AdicionarLivroProvider;
import school.sptech.providers.biblioteca.BuscarLivroPorTituloProvider;
import school.sptech.providers.biblioteca.ContarLivrosProvider;
import school.sptech.providers.biblioteca.ObterLivrosAteAnoProvider;
import school.sptech.providers.biblioteca.RemoverLivroPorTituloIgnoreCaseProvider;
import school.sptech.providers.biblioteca.RemoverLivroPorTituloProvider;
import school.sptech.providers.biblioteca.RetornarTopCincoLivrosProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Biblioteca")
public class BibliotecaTest {

    @Nested
    @DisplayName("1. Atributos")
    class AtributosTest {

        @Test
        @DisplayName("1. Validar atributos")
        void validarAtributos() {
            Class<Biblioteca> clazz = Biblioteca.class;
            assertAll(
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("nome")),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("livros"))
            );
        }
    }

    @Nested
    @DisplayName("2. Validar métodos")
    class MetodosTest {

        @Test
        void validarMetodos() {
            Class<Biblioteca> clazz = Biblioteca.class;

            assertAll(
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("adicionarLivro", Livro.class)),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("removerLivroPorTitulo", String.class)),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("buscarLivroPorTitulo", String.class)),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("contarLivros")),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("obterLivrosAteAno", Integer.class)),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("retornarTopCincoLivros"))
            );
        }
    }

    @Nested
    @DisplayName("3. Encapsulamento")
    class EncapsulamentoTest {

        @Test
        @DisplayName("1. Atributos Privados")
        void validarEncapsulamento() {
            Class<Biblioteca> clazz = Biblioteca.class;

            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                    .map(campo -> () -> assertTrue(Modifier.isPrivate(campo.getModifiers())));

            assertAll(validacoes);
        }

        @Test
        @DisplayName("2. Métodos Públicos")
        void validarMetodosPublicos() {
            Class<Biblioteca> clazz = Biblioteca.class;

            List<Method> metodos = new ArrayList<>();

            try {
                metodos.add(clazz.getDeclaredMethod("adicionarLivro", Livro.class));
            } catch (ReflectiveOperationException ignored) {}

            try {
                metodos.add(clazz.getDeclaredMethod("removerLivroPorTitulo", String.class));
            } catch (ReflectiveOperationException ignored) {}

            try {
                metodos.add(clazz.getDeclaredMethod("buscarLivroPorTitulo", String.class));
            } catch (ReflectiveOperationException ignored) {}

            try {
                metodos.add(clazz.getDeclaredMethod("contarLivros"));
            } catch (ReflectiveOperationException ignored) {}

            try {
                metodos.add(clazz.getDeclaredMethod("obterLivrosAteAno", Integer.class));
            } catch (ReflectiveOperationException ignored) {}

            try {
                metodos.add(clazz.getDeclaredMethod("retornarTopCincoLivros"));
            } catch (ReflectiveOperationException ignored) {}

            Stream<Executable> validacoes = metodos.stream()
                    .map((metodo) -> () -> {
                        assertTrue(Modifier.isPublic(metodo.getModifiers()));
                    });

            assertAll(validacoes);
        }

        @Test
        @DisplayName("3. Atributo nome deve possuir getters e setters")
        void test3() throws NoSuchFieldException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Field[] campos = new Field[] { clazz.getDeclaredField("nome") };

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
        @DisplayName("4. Atributo livros não podem possuir getters e setters")
        void test4() throws NoSuchFieldException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Field[] campos = new Field[] { clazz.getDeclaredField("livros") };

            Stream<Executable> validacoesGetter = Arrays.stream(campos)
                    .map(campo -> () -> {
                        String getName = String.format("get%s",
                                StringUtils.capitalize(campo.getName()));

                        assertThrows(NoSuchMethodException.class, () -> {
                            Method getter = clazz.getDeclaredMethod(getName);
                            int getModifier = getter.getModifiers();
                            assertTrue(Modifier.isPublic(getModifier));
                        });
                    });

            Stream<Executable> validacoesSetter = Arrays.stream(campos)
                    .map(campo -> () -> {
                        String setName = String.format("set%s",
                                StringUtils.capitalize(campo.getName()));
                        assertThrows(NoSuchMethodException.class, () -> {
                            Method setter = clazz.getDeclaredMethod(setName, campo.getType());
                            int setModifier = setter.getModifiers();
                            assertTrue(Modifier.isPublic(setModifier));
                        });
                    });

            assertAll(Stream.concat(validacoesGetter, validacoesSetter));
        }

        @Test
        @DisplayName("5. Lista de livros ao criar o objeto não pode ser nula")
        void test5() throws ReflectiveOperationException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
            Object[] parameters = Arrays.stream(constructor.getParameters()).map(param -> null).toArray();

            Object livro = constructor.newInstance(parameters);

            Field campoLivros = clazz.getDeclaredField("livros");
            campoLivros.trySetAccessible();

            assertNotNull(campoLivros.get(livro));
        }
    }

    @Nested
    @DisplayName("4. Adicionar Livro")
    class ValidarMetodoAdicionarLivro {

        @ParameterizedTest
        @ArgumentsSource(AdicionarLivroProvider.class)
        @DisplayName("1. Adicionando livros válidos")
        void test1(String nome, List<Livro> livros, Livro livro, List<?> expected) throws ReflectiveOperationException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("adicionarLivro", Livro.class);

            Object obj = BibliotecaFactory.build(nome, new ArrayList<>(livros));

            method.invoke(obj, livro);

            Field field = clazz.getDeclaredField("livros");
            field.setAccessible(true);

            List<?> result = (List<?>) field.get(obj);

            assertIterableEquals(expected, result);
        }

        @ParameterizedTest
        @ArgumentsSource(AdicionarLivroInvalidoProvider.class)
        @DisplayName("2. Adicionando livros inválidos")
        void test2(String nome, List<Livro> livros, Livro livro, List<?> expected) throws ReflectiveOperationException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("adicionarLivro", Livro.class);

            Object obj = BibliotecaFactory.build(nome, new ArrayList<>(livros));

            method.invoke(obj, livro);

            Field field = clazz.getDeclaredField("livros");
            field.setAccessible(true);

            List<?> result = (List<?>) field.get(obj);

            assertIterableEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("5. Remover Livro por titulo")
    class RemoverLivro {

        @ParameterizedTest
        @ArgumentsSource(RemoverLivroPorTituloProvider.class)
        void validarRemoverLivroPorTitulo(
              List<Livro> livrosAll,
              String titulo,
              List<Livro> livrosFilters
        ) throws ReflectiveOperationException {

            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("removerLivroPorTitulo", String.class);

            Object obj = BibliotecaFactory.build("Biblioteca", new ArrayList<>(livrosAll));

            method.invoke(obj, titulo);

            Field field = clazz.getDeclaredField("livros");

            field.setAccessible(true);

            List<Livro> livros = (List<Livro>) field.get(obj);

            assertIterableEquals(livrosFilters, livros);
        }

        @ParameterizedTest
        @ArgumentsSource(RemoverLivroPorTituloIgnoreCaseProvider.class)
        void validarRemoverLivroPorTituloIgnoreCase(
              List<Livro> livrosAll,
              String titulo,
              List<Livro> livrosFilters
        ) throws ReflectiveOperationException {

            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("removerLivroPorTitulo", String.class);

            Object obj = BibliotecaFactory.build("Biblioteca", new ArrayList<>(livrosAll));

            method.invoke(obj, titulo);

            Field field = clazz.getDeclaredField("livros");

            field.setAccessible(true);

            List<Livro> livros = (List<Livro>) field.get(obj);

            assertIterableEquals(livrosFilters, livros);
        }
    }

    @Nested
    @DisplayName("6. Buscar Livro por Título")
    class RemoverLivroPorTitulo {

        @ParameterizedTest
        @ArgumentsSource(BuscarLivroPorTituloProvider.class)
        void validarBuscarLivroPorTitulo(
              List<Livro> livrosAll,
              String titulo,
              Livro expected
        ) throws ReflectiveOperationException {

            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("buscarLivroPorTitulo", String.class);

            Object obj = BibliotecaFactory.build("Biblioteca", livrosAll);

            Livro retorno = (Livro) method.invoke(obj, titulo);

            assertEquals(expected, retorno);
        }
    }

    @Nested
    @DisplayName("7 Contar Livros")
    class ContarLivros {

        @ParameterizedTest
        @ArgumentsSource(ContarLivrosProvider.class)
        void validarContarLivros(List<Livro> livros, Integer expected)
              throws ReflectiveOperationException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("contarLivros");

            Object obj = BibliotecaFactory.build("Biblioteca", livros);

            Integer retorno = (Integer) method.invoke(obj);

            assertEquals(expected, retorno);
        }
    }

    @Nested
    @DisplayName("8. Obter Livros por Ano")
    class ValidarObterLivrosAteAno {

        @ParameterizedTest
        @ArgumentsSource(ObterLivrosAteAnoProvider.class)
        void validarObterLivrosAntigosTeste(List<Livro> livros, Integer ano, List<Livro> expected) throws ReflectiveOperationException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("obterLivrosAteAno", Integer.class);

            Object obj = BibliotecaFactory.build("Biblioteca", livros);
            List<?> retorno = (List<?>) method.invoke(obj, ano);

            assertIterableEquals(expected, retorno);
        }
    }

    @Nested
    @DisplayName("9. Retornar Top Cinco Livros")
    class ValidarTopCincoLivros {

        @ParameterizedTest
        @ArgumentsSource(RetornarTopCincoLivrosProvider.class)
        void validarRetornarTopCincoLivros(List<Livro> livros, List<Livro> expected, String message) throws ReflectiveOperationException {
            Class<Biblioteca> clazz = Biblioteca.class;
            Method method = clazz.getDeclaredMethod("retornarTopCincoLivros");

            Object obj = BibliotecaFactory.build("Biblioteca", new ArrayList<>(livros));
            List<?> retorno = (List<?>) method.invoke(obj);

            assertIterableEquals(expected, retorno, message);
        }
    }
}
