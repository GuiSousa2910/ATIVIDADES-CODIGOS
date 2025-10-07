package school.sptech.exemplo_curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.exemplo_curso.entity.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByCursoNomeContainingIgnoreCase(String nomeCurso);

    @Query("SELECT COALESCE(AVG(c.preco), 0) FROM Curso c")
    Double buscarMedia();
}