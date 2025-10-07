package school.sptech.exemplo_paginacao.controller.musica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotNull;
import school.sptech.exemplo_paginacao.entity.album.Album;
import school.sptech.exemplo_paginacao.entity.musica.Musica;

public record MusicaCadastrarDTO(
        @NotBlank String nome,
        @PositiveOrZero double duracao,
        @NotNull Integer idAlbum
) {

        public static MusicaCadastrarDTO toDto(Musica musica) {
                return new MusicaCadastrarDTO(
                        musica.getNome(),
                        musica.getDuracao(),
                        musica.getAlbum().getId()
                );
        }

        public Musica toEntity() {
                return Musica.builder()
                        .nome(nome)
                        .duracao(duracao)
                        .album(Album.builder().id(idAlbum).build())
                        .build();
        }
}