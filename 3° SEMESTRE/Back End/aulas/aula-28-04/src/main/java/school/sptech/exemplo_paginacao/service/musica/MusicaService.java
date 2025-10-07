package school.sptech.exemplo_paginacao.service.musica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.exemplo_paginacao.entity.musica.Musica;
import school.sptech.exemplo_paginacao.entity.musica.MusicaRepository;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository repository;

    public Musica cadastrarMusica(Musica musica) {
        return repository.save(musica);
    }

    public Musica buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Música não encontrada"));
    }
}