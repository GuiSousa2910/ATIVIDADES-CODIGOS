package school.sptech.provider.eletronico;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

public class DisponivelParaCompraProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Televisão", 2500.00, 8.00, 30, LocalDate.parse("2024-01-01"), true, true),
                Arguments.of("Smartphone", 3500.00, 0.20, 50, LocalDate.parse("2016-01-10"), false, false),
                Arguments.of("Notebook", 4000.00, 2.50, 0, LocalDate.parse("2010-01-01"), true, false),
                Arguments.of("Fone de ouvido", 200.00, 0.10, 100, LocalDate.parse("2022-01-01"), false, true),
                Arguments.of("Caixa de som", 500.00, 1.50, 80, LocalDate.parse("2020-10-29"), true, true),
                Arguments.of("Tablet", 1800.00, 0.70, 40, LocalDate.parse("1999-08-24"), false, false),
                Arguments.of("Impressora", 1200.00, 3.50, 60, LocalDate.parse("2024-03-19"), true, true),
                Arguments.of("Monitor", 900.00, 4.00, 45, LocalDate.parse("2000-11-28"), true, false),
                Arguments.of("Teclado mecânico", 300.00, 0.80, 75, LocalDate.parse("2019-01-01"), false, false),
                Arguments.of("Câmera digital", 2500.00, 1.00, 20, LocalDate.parse("2024-02-23"), false, true)
        );
    }
}
