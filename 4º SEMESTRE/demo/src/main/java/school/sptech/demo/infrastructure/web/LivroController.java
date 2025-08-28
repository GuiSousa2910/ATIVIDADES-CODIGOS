package school.sptech.demo.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.demo.core.application.CriarLivrosUseCase;
import school.sptech.demo.core.application.command.CriarLivroCommand;
import school.sptech.demo.core.domain.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final CriarLivrosUseCase criarLivrosUseCase;

    public LivroController(CriarLivrosUseCase criarLivrosUseCase) {
        this.criarLivrosUseCase = criarLivrosUseCase;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody CriarLivroCommand command){
        Livro livro = criarLivrosUseCase.executar(command);
        return ResponseEntity.status(201).body(livro);
    }
}
