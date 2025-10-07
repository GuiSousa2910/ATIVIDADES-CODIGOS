package school.sptech.exemplo_curso.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.exemplo_curso.entity.Aluno;
import school.sptech.exemplo_curso.repository.AlunoRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public List<Aluno> buscarPorCursoNome(String nomeProcurado) {
        return alunoRepository.findByCursoNomeContainingIgnoreCase(nomeProcurado);
    }

    public Double mediaValor() {
        return alunoRepository.buscarMedia();
    }
}