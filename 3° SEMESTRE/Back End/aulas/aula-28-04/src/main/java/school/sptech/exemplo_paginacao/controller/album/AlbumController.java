package school.sptech.exemplo_paginacao.controller.album;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_paginacao.controller.album.dto.*;
import school.sptech.exemplo_paginacao.entity.album.Album;
import school.sptech.exemplo_paginacao.service.album.AlbumService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/albuns")
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<AlbumListagemDto>> listar() {
        List<Album> listar = albumService.listar();

        if (listar.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(AlbumMapper.toListagemDto(listar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumPorIdDto> buscarPorId(@PathVariable Integer id) {
        Album album = albumService.buscarPorId(id);
        return ResponseEntity.ok(AlbumMapper.toPorIdDto(album));
    }

    @PostMapping
    public ResponseEntity<AlbumPorIdDto> cadastrar(@RequestBody AlbumCadastroDto cadastroDto) {

        Album album = AlbumMapper.toEntity(cadastroDto);
        Album albumCadastrado = albumService.cadastrar(album);
        return ResponseEntity.status(201).body(AlbumMapper.toPorIdDto(albumCadastrado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumPorIdDto> atualizar(@PathVariable Integer id, @RequestBody AlbumAtualizacaoDto atualizacaoDto) {
        Album album = AlbumMapper.toEntity(atualizacaoDto, id);
        Album albumAtualizado = albumService.atualizar(album);
        return ResponseEntity.ok(AlbumMapper.toPorIdDto(albumAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        albumService.removerPorId(id);
        return ResponseEntity.noContent().build();
    }
}
