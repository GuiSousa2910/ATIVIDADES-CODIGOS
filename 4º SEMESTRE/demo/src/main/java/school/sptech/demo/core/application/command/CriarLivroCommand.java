package school.sptech.demo.core.application.command;

public record CriarLivroCommand(
        String titulo,
        String isbn
) {
}
