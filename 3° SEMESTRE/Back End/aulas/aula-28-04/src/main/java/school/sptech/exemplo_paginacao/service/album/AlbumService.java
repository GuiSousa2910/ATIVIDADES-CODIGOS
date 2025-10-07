package school.sptech.exemplo_paginacao.service.album;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.exemplo_paginacao.entity.album.Album;
import school.sptech.exemplo_paginacao.exception.EntidadeNaoEncontradaException;
import school.sptech.exemplo_paginacao.entity.album.AlbumRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public Album cadastrar(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> listar() {
        return albumRepository.findAll();
    }

    public Album buscarPorId(Integer id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Album não encontrado"));
    }

    public void removerPorId(Integer id) {
        if (!albumRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Album não encontrado");
        }
        albumRepository.deleteById(id);
    }

    public Album atualizar(Album album) {
        if (!albumRepository.existsById(album.getId())) {
            throw new EntidadeNaoEncontradaException("Album não encontrado");
        }
        return albumRepository.save(album);
    }
}
