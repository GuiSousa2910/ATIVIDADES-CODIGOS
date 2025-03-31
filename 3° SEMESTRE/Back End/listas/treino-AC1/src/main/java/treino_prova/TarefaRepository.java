package school.sptech.treino_prova;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findByTituloContainingIgnoreCase(String titulo);

    boolean existsByTituloIgnoreCase(String titulo);

    List<Tarefa> findByPrazoBetween(LocalDateTime inicio, LocalDateTime fim);
}
