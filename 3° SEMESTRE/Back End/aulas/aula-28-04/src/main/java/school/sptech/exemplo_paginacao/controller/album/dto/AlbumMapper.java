package school.sptech.exemplo_paginacao.controller.album.dto;

import org.springframework.data.domain.Page;
import school.sptech.exemplo_paginacao.entity.album.Album;

import java.util.List;

public class AlbumMapper {

    public static AlbumListagemDto toListagemDto(Album entity) {
        if (entity == null) {
            return null;
        }
        return new AlbumListagemDto(entity.getId(), entity.getNome());
    }

    public static List<AlbumListagemDto> toListagemDto(List<Album> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(AlbumMapper::toListagemDto)
                .toList();
    }

    public static List<AlbumListagemDto> toListagemDto(Page<Album> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(AlbumMapper::toListagemDto)
                .toList();
    }

    public static AlbumPorIdDto toPorIdDto(Album entity) {
        if (entity == null) {
            return null;
        }
        return new AlbumPorIdDto(
                entity.getId(),
                entity.getNome(),
                entity.getArtista(),
                entity.getNota(),
                entity.getDataLancamento()
        );
    }

    public static Album toEntity(AlbumCadastroDto dto) {
        if (dto == null) {
            return null;
        }
        return Album.builder()
                .nome(dto.nome())
                .artista(dto.artista())
                .nota(dto.nota())
                .dataLancamento(dto.dataLancamento())
                .build();
    }

    public static Album toEntity(AlbumAtualizacaoDto dto, int id) {
        if (dto == null) {
            return null;
        }
        return Album.builder()
                .id(id)
                .nome(dto.nome())
                .artista(dto.artista())
                .nota(dto.nota())
                .dataLancamento(dto.dataLancamento())
                .build();
    }
}
