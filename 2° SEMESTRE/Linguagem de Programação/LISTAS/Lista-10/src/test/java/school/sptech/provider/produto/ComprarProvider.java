package school.sptech.provider.produto;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ComprarProvider {

    public static class ValorValido implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("Sabão em pó", 9.90, 1.20, 80, 10, 70),
                    Arguments.of("Detergente Liquido", 6.50, 0.75, 120, 100, 20),
                    Arguments.of("Shampoo", 15.00, 0.30, 60, 30, 30),
                    Arguments.of("Condicionador", 17.0, 0.30, 55, 5, 50),
                    Arguments.of("Pasta de dente", 8.20, 0.10, 100, 2, 98),
                    Arguments.of("Desinfetante", 10.50, 1.00, 90, 90, 0),
                    Arguments.of("Água sanitária", 5.00, 2.00, 70, 69, 1),
                    Arguments.of("Esponja de aço", 3.00, 0.05, 200, 1, 199),
                    Arguments.of("Sabonete líquido", 7.80, 0.25, 110, 10, 100),
                    Arguments.of("Fio dental", 6.00, 0.05, 150, 36, 114)
            );
        }
    }

    public static class ValorInvalido implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("Sabão em pó", 9.90, 1.20, 80, 90, 80),
                    Arguments.of("Detergente Liquido", 6.50, 0.75, 120, 200, 120),
                    Arguments.of("Shampoo", 15.00, 0.30, 60, 90, 60),
                    Arguments.of("Condicionador", 17.0, 0.30, 55, 56, 55),
                    Arguments.of("Pasta de dente", 8.20, 0.10, 100, 110, 100),
                    Arguments.of("Desinfetante", 10.50, 1.00, 90, 100, 90),
                    Arguments.of("Água sanitária", 5.00, 2.00, 70, 999, 70),
                    Arguments.of("Esponja de aço", 3.00, 0.05, 200, 700, 200),
                    Arguments.of("Sabonete líquido", 7.80, 0.25, 110, 117, 110),
                    Arguments.of("Fio dental", 6.00, 0.05, 150, 151, 150)
            );
        }
    }

    public static class ValorNegativo implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("Sabão em pó", 9.90, 1.20, 80, -10, 80),
                    Arguments.of("Detergente Liquido", 6.50, 0.75, 120, -1, 120),
                    Arguments.of("Shampoo", 15.00, 0.30, 60, -111, 60),
                    Arguments.of("Condicionador", 17.0, 0.30, 55, -8, 55),
                    Arguments.of("Pasta de dente", 8.20, 0.10, 100, -28, 100),
                    Arguments.of("Desinfetante", 10.50, 1.00, 90, -1, 90),
                    Arguments.of("Água sanitária", 5.00, 2.00, 70, -192, 70),
                    Arguments.of("Esponja de aço", 3.00, 0.05, 200, -22, 200),
                    Arguments.of("Sabonete líquido", 7.80, 0.25, 110, -237, 110),
                    Arguments.of("Fio dental", 6.00, 0.05, 150, -7, 150)
            );
        }
    }
}
