package school.sptech.providers.biblioteca;

import school.sptech.factory.LivroFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ObterLivrosAteAnoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        // Livros clássicos
        Object livro1 = LivroFactory.build("Dom Quixote", "Miguel de Cervantes", LocalDate.parse("1605-01-16"), new ArrayList<>());
        Object livro2 = LivroFactory.build("Hamlet", "William Shakespeare", LocalDate.parse("1603-01-01"), new ArrayList<>());

        // Livros do século XIX e XX
        Object livro3 = LivroFactory.build("Guerra e Paz", "Liev Tolstói", LocalDate.parse("1869-01-01"), new ArrayList<>());
        Object livro4 = LivroFactory.build("1984", "George Orwell", LocalDate.parse("1949-06-08"), new ArrayList<>());

        // Livros contemporâneos
        Object livro5 = LivroFactory.build("Harry Potter e a Pedra Filosofal", "J. K. Rowling", LocalDate.parse("1997-06-26"), new ArrayList<>());
        Object livro6 = LivroFactory.build("O Senhor dos Anéis", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object livro7 = LivroFactory.build("O Pequeno Príncipe", "Antoine de Saint-Exupéry", LocalDate.parse("1943-04-06"), new ArrayList<>());

        // Livros recentes
        Object livro8 = LivroFactory.build("O Código Da Vinci", "Dan Brown", LocalDate.parse("2003-03-18"), new ArrayList<>());
        Object livro9 = LivroFactory.build("A Garota no Trem", "Paula Hawkins", LocalDate.parse("2015-01-13"), new ArrayList<>());

        // Lista de todos os livros
        List<Object> livros = List.of(livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8, livro9);

        return Stream.of(
                Arguments.of(livros, 1605, List.of(livro1,livro2)),
                Arguments.of(livros, 1900, List.of(livro1, livro2, livro3)),
                Arguments.of(livros, 1950, List.of(livro1, livro2, livro3, livro4, livro7)),
                Arguments.of(livros, 2000, List.of(livro1, livro2, livro3, livro4, livro5, livro6, livro7)),
                Arguments.of(livros, 2020, List.of(livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8, livro9)),
                Arguments.of(livros, 1500, List.of()),
                Arguments.of(livros, 2022, livros),
                Arguments.of(livros, 1955, List.of(livro1, livro2, livro3, livro4, livro6, livro7))
        );
    }
}
