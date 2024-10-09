package school.sptech.provider.produto;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class AumentarEstoqueProvider {

    public static class ValorValido implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("Sabão em pó", 9.90, 1.20, 80, 10, 90),
                    Arguments.of("Detergente Liquido", 6.50, 0.75, 120, 100, 220),
                    Arguments.of("Shampoo", 15.00, 0.30, 60, 30, 90),
                    Arguments.of("Condicionador", 17.0, 0.30, 55, 5, 60),
                    Arguments.of("Pasta de dente", 8.20, 0.10, 100, 2, 102),
                    Arguments.of("Desinfetante", 10.50, 1.00, 90, 90, 180),
                    Arguments.of("Água sanitária", 5.00, 2.00, 70, 69, 139),
                    Arguments.of("Esponja de aço", 3.00, 0.05, 200, 1, 201),
                    Arguments.of("Sabonete líquido", 7.80, 0.25, 110, 10, 120),
                    Arguments.of("Fio dental", 6.00, 0.05, 150, 36, 186)
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
