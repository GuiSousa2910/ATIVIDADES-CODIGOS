package school.sptech.provider.produto;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CalcularImpostoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Sabão em pó", 9.90, 1.20, 80, 0.495),
                Arguments.of("Detergente Liquido", 6.50, 0.75, 120, 0.325),
                Arguments.of("Shampoo", 15.00, 0.30, 60, 0.75),
                Arguments.of("Condicionador", 17.0, 0.30, 55, 0.85),
                Arguments.of("Pasta de dente", 8.20, 0.10, 100, 0.41),
                Arguments.of("Desinfetante", 10.50, 1.00, 90, 0.525),
                Arguments.of("Água sanitária", 5.00, 2.00, 70, 0.25),
                Arguments.of("Esponja de aço", 3.00, 0.05, 200, 0.15),
                Arguments.of("Sabonete líquido", 7.80, 0.25, 110, 0.39),
                Arguments.of("Fio dental", 6.00, 0.05, 150, 0.30)
        );
    }
}
