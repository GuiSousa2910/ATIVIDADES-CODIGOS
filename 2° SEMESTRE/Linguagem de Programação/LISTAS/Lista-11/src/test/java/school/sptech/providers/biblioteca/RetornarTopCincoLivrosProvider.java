package school.sptech.providers.biblioteca;

import school.sptech.factory.AvaliacaoFactory;
import school.sptech.factory.LivroFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class RetornarTopCincoLivrosProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        List<Object> avaliacoes = List.of(
                AvaliacaoFactory.build("Muito bom", 5.0),
                AvaliacaoFactory.build("Bom", 4.0),
                AvaliacaoFactory.build("Regular", 3.0),
                AvaliacaoFactory.build("Ruim", 2.0),
                AvaliacaoFactory.build("Péssimo", 1.0)
        );

        Object livro1 = LivroFactory.build("O Senhor dos Anéis", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), avaliacoes.subList(0, 2)); // média 4.5
        Object livro2 = LivroFactory.build("Harry Potter e a Pedra Filosofal", "J. K. Rowling", LocalDate.parse("1997-06-26"), avaliacoes.subList(0, 3)); // média 4.0
        Object livro3 = LivroFactory.build("O Pequeno Príncipe", "Antoine de Saint-Exupéry", LocalDate.parse("1943-04-06"), avaliacoes.subList(0, 1)); // média 5.0
        Object livro4 = LivroFactory.build("Dom Quixote", "Miguel de Cervantes", LocalDate.parse("1605-01-16"), avaliacoes.subList(0, 4)); // média 3.75
        Object livro5 = LivroFactory.build("1984", "George Orwell", LocalDate.parse("1949-06-08"), avaliacoes.subList(0, 5)); // média 3.0
        Object livro6 = LivroFactory.build("O Senhor dos Anéis 2", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), avaliacoes.subList(0, 2)); // média 4.5
        Object livro7 = LivroFactory.build("Harry Potter e a Pedra Filosofal 2", "J. K. Rowling", LocalDate.parse("1997-06-26"), avaliacoes.subList(0, 3)); // média 4.0

        List<Object> livrosComMaisDeCinco = List.of(livro1, livro2, livro3, livro4, livro5, livro6, livro7);
        List<Object> livrosComExatamenteCinco = List.of(livro1, livro2, livro3, livro4, livro5);
        List<Object> livrosComMenosDeCinco = List.of(livro1, livro2, livro3);
        List<Object> livrosVazia = Collections.emptyList();

        List<Object> topCincoLivrosComMaisDeCinco = List.of(livro3, livro1, livro6, livro2, livro7);
        List<Object> topCincoLivrosComExatamenteCinco = List.of(livro3, livro1, livro2, livro4, livro5);
        List<Object> topCincoLivrosComMenosDeCinco = List.of(livro3, livro1, livro2);

        return Stream.of(
                Arguments.of(livrosComMaisDeCinco, topCincoLivrosComMaisDeCinco, "Testando com mais de cinco livros"),
                Arguments.of(livrosComExatamenteCinco, topCincoLivrosComExatamenteCinco, "Testando com exatamente cinco livros"),
                Arguments.of(livrosComMenosDeCinco, topCincoLivrosComMenosDeCinco, "Testando com menos de cinco livros"),
                Arguments.of(livrosVazia, List.of(), "Testando com lista vazia")
        );
    }
}
