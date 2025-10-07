package school.sptech.exemplo_paginacao.controller.album.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlbumCadastroDto(
        @NotBlank String nome,
        @NotBlank String artista,
        @NotNull double nota,
        @NotNull LocalDate dataLancamento
) {
}
