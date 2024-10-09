package school.sptech.provider.produto;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DisponivelParaCompraProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Sabão em pó", 9.90, 1.20, 0, false),
                Arguments.of("Detergente Liquido", 6.50, 0.75, 120, true),
                Arguments.of("Shampoo", 15.00, 0.30, 60, true),
                Arguments.of("Condicionador", 17.0, 0.30, 55, true),
                Arguments.of("Pasta de dente", 8.20, 0.10, 0, false),
                Arguments.of("Desinfetante", 10.50, 1.00, 90, true),
                Arguments.of("Água sanitária", 5.00, 2.00, 0, false),
                Arguments.of("Esponja de aço", 3.00, 0.05, 200, true),
                Arguments.of("Sabonete líquido", 7.80, 0.25, 110, true),
                Arguments.of("Fio dental", 6.00, 0.05, 150, true)
        );
    }
}
