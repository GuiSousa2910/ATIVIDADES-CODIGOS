package school.sptech.providers.biblioteca;

import school.sptech.factory.LivroFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BuscarLivroPorTituloProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Object book1 = LivroFactory.build("O Senhor dos Anéis", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object book2 = LivroFactory.build("Harry Potter e a Pedra Filosofal", "J. K. Rowling", LocalDate.parse("1997-06-26"), new ArrayList<>());
        Object book3 = LivroFactory.build("O Pequeno Príncipe", "Antoine de Saint-Exupéry", LocalDate.parse("1943-04-06"), new ArrayList<>());
        Object book4 = LivroFactory.build("Dom Quixote", "Miguel de Cervantes", LocalDate.parse("1605-01-16"), new ArrayList<>());
        Object book5 = LivroFactory.build("1984", "George Orwell", LocalDate.parse("1949-06-08"), new ArrayList<>());

        List<Object> list = List.of(book1, book2, book3, book4, book5);

        return Stream.of(
                Arguments.of(list, "O Senhor dos Anéis", book1),
                Arguments.of(list, "harry Potter e a Pedra Filosofal", book2),
                Arguments.of(list, "O Pequeno Príncipe", book3),
                Arguments.of(list, "Dom quixote", book4),
                Arguments.of(list, "1984", book5),
                Arguments.of(list, "O Senhor dos Anéis 2", null),
                Arguments.of(list, "Harry Potter e a Pedra Filosofal 2", null),
                Arguments.of(list, null, null),
                Arguments.of(list, "O Pequeno Principe", null),
                Arguments.of(list, "o pequeno príncipe", book3)

        );
    }
}
