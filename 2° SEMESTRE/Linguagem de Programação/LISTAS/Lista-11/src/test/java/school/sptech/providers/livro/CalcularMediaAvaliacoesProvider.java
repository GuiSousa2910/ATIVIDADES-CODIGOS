package school.sptech.providers.livro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import school.sptech.factory.AvaliacaoFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class CalcularMediaAvaliacoesProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Object a1 = AvaliacaoFactory.build("Uma leitura cativante do início ao fim.", 5.0);
        Object a2 = AvaliacaoFactory.build("A história é boa, mas os personagens são pouco desenvolvidos.", 3.0);
        Object a3 = AvaliacaoFactory.build("Estilo de escrita difícil de acompanhar.", 2.0);
        Object a4 = AvaliacaoFactory.build("Enredo original e surpreendente, mas um pouco arrastado.", 4.0);
        Object a5 = AvaliacaoFactory.build("Previsível e sem grandes emoções.", 2.0);
        Object a6 = AvaliacaoFactory.build("Uma obra-prima da literatura moderna.", 5.0);
        Object a7 = AvaliacaoFactory.build("A premissa é interessante, mas mal executada.", 3.0);
        Object a8 = AvaliacaoFactory.build("Um clássico que todos deveriam ler.", 5.0);
        Object a9 = AvaliacaoFactory.build("Achei a trama confusa e pouco envolvente.", 1.0);
        Object a10 = AvaliacaoFactory.build("Narrativa envolvente, mas o final decepcionou.", 3.0);

        return Stream.of(
                Arguments.of("O Senhor dos Anéis", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), List.of(), 0.0),
                Arguments.of("Harry Potter e a Pedra Filosofal", "J. K. Rowling", LocalDate.parse("1997-06-26"), List.of(a3, a4), 3.0),
                Arguments.of("O Pequeno Príncipe", "Antoine de Saint-Exupéry", LocalDate.parse("1943-04-06"), List.of(a1, a2, a3), 3.33),
                Arguments.of("Dom Quixote", "Miguel de Cervantes", LocalDate.parse("1605-01-16"), List.of(a1, a3, a6, a9), 3.25),
                Arguments.of("1984", "George Orwell", LocalDate.parse("1949-06-08"), List.of(a5, a7), 2.5)
        );
    }
}
