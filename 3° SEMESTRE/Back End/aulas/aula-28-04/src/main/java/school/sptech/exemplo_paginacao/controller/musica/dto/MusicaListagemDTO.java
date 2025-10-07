package school.sptech.exemplo_paginacao.controller.musica.dto;

import school.sptech.exemplo_paginacao.entity.album.Album;
import school.sptech.exemplo_paginacao.entity.musica.Musica;

public record MusicaListagemDTO(
        Long id,
        String nome,
        double duracao,
        Album album
) {

    public static MusicaListagemDTO toDto(Musica musica) {
        return new MusicaListagemDTO(
                musica.getId(),
                musica.getNome(),
                musica.getDuracao(),
                Album.builder()
                        .id(musica.getAlbum().getId())
                        .nome(musica.getAlbum().getNome())
                        .nota(musica.getAlbum().getNota())
                        .artista(musica.getAlbum().getArtista())
                        .dataLancamento(musica.getAlbum().getDataLancamento())
                        .build()
        );
    }
}
