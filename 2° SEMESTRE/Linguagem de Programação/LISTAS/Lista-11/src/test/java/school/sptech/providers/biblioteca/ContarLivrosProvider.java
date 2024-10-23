package school.sptech.providers.biblioteca;

import school.sptech.factory.LivroFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import school.sptech.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ContarLivrosProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        List<Livro> livros = List.of(
                LivroFactory.buildBook("O Senhor dos Anéis", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), new ArrayList<>()),
                LivroFactory.buildBook("Harry Potter e a Pedra Filosofal", "J. K. Rowling", LocalDate.parse("1997-06-26"), new ArrayList<>()),
                LivroFactory.buildBook("O Pequeno Príncipe", "Antoine de Saint-Exupéry", LocalDate.parse("1943-04-06"), new ArrayList<>()),
                LivroFactory.buildBook("Dom Quixote", "Miguel de Cervantes", LocalDate.parse("1605-01-16"), new ArrayList<>()),
                LivroFactory.buildBook("1984", "George Orwell", LocalDate.parse("1949-06-08"), new ArrayList<>())
        );

        return Stream.of(
                Arguments.of(new ArrayList<>(), 0), // Para 0 livros
                Arguments.of(new ArrayList<>(livros.subList(0, 1)), 1),
                Arguments.of(new ArrayList<>(livros.subList(0, 2)), 2),
                Arguments.of(new ArrayList<>(livros.subList(0, 3)), 3),
                Arguments.of(new ArrayList<>(livros.subList(0, 4)), 4),
                Arguments.of(new ArrayList<>(livros), 5)
        );
    }
}
