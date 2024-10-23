package school.sptech;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

@DisplayName("Avaliacao")
public class AvaliacaoTest {

    @Nested
    @DisplayName("1. Atributos")
    class AtributosTest {

        @Test
        @DisplayName("1. Validar Atributos")
        void validarAtributos() {
            Class<Avaliacao> clazz = Avaliacao.class;
            assertAll(
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("descricao")),
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredField("qtdEstrelas"))
            );
        }
    }

    @Nested
    @DisplayName("2. Encapsulamento")
    class EncapsulamentoTest {

        @Test
        @DisplayName("1. Atributos Privados")
        void validarEncapsulamento() {
            Class<Avaliacao> clazz = Avaliacao.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                    .map(campo -> () -> assertTrue(Modifier.isPrivate(campo.getModifiers()),
                            String.format("%s deve ser privado", campo.getName())));

            assertAll(validacoes);
        }

        @Test
        @DisplayName("2. Atributos devem possuir getters e setters")
        void validarMetodos() {
            Class<Avaliacao> clazz = Avaliacao.class;
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
    }

    @Nested
    @DisplayName("3. toString")
    class ValidarToStringTest {

        @Test
        @DisplayName("1. Deve possuir o método toString")
        void validarToString() {
            Class<Avaliacao> clazz = Avaliacao.class;
            assertAll(
                  () -> assertDoesNotThrow(() -> clazz.getDeclaredMethod("toString"))
            );
        }
    }
}
