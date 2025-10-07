package school.sptech.exemplo_paginacao.controller.musica;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_paginacao.controller.musica.dto.MusicaCadastrarDTO;
import school.sptech.exemplo_paginacao.controller.musica.dto.MusicaListagemDTO;
import school.sptech.exemplo_paginacao.service.musica.MusicaService;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    @Autowired
    private MusicaService service;

    @PostMapping
    public ResponseEntity<MusicaCadastrarDTO> cadastrar(@Valid @RequestBody MusicaCadastrarDTO dto) {
        var musica = service.cadastrarMusica(dto.toEntity());
        return ResponseEntity.status(201).body(MusicaCadastrarDTO.toDto(musica));
    }

    @GetMapping
    public ResponseEntity<MusicaListagemDTO> buscarPorId(@RequestParam Long id) {
        var musica = service.buscarPorId(id);
        return ResponseEntity.ok(MusicaListagemDTO.toDto(musica));
    }
}
