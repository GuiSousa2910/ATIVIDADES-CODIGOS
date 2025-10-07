package school.sptech.exemplo_paginacao.controller.album.dto;

import java.time.LocalDate;

public record AlbumPorIdDto(
        Integer id,
        String nome,
        String artista,
        double nota,
        LocalDate dataLancamento
) {
}
