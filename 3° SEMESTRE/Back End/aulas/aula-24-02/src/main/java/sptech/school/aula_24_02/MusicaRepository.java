package sptech.school.aula_24_02;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Integer>{
    Musica findTop1ByOrderByDataLancamentoDesc();
    Musica findByDataLancamentoLessThan(LocalDate data);
}