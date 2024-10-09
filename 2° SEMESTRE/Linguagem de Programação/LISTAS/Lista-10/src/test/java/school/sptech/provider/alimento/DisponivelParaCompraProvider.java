package school.sptech.provider.alimento;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

public class DisponivelParaCompraProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Arroz", 5.50, 1.0, 100, LocalDate.parse("2024-10-05"), true),
                Arguments.of("Feijão", 8.00, 1.0, 0, LocalDate.parse("2024-10-12"), false),
                Arguments.of("Macarrão", 4.30, 0.50, 200, LocalDate.parse("2024-08-24"), false),
                Arguments.of("Açúcar", 3.75, 1.00, 120, LocalDate.parse("2024-10-24"), true),
                Arguments.of("Farinha", 6.20, 1.00, 180, LocalDate.parse("2024-11-13"), true),
                Arguments.of("Leite", 4.50, 1.00, 90, LocalDate.parse("2024-09-30"), false),
                Arguments.of("Óleo de Soja", 7.80, 0.90, 75, LocalDate.parse("2024-12-01"), true),
                Arguments.of("Café", 15.00, 0.50, 50, LocalDate.parse("2024-10-03"), true),
                Arguments.of("Achocolatado", 12.00, 0.40, 0, LocalDate.parse("2024-10-10"), false),
                Arguments.of("Sabão em pó", 9.90, 1.20, 80, LocalDate.parse("2024-10-08"), true)
        );
    }
}
