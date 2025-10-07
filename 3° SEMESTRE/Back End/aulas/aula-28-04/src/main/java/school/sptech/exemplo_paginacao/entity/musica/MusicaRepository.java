package school.sptech.exemplo_paginacao.entity.musica;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_paginacao.entity.album.Album;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
