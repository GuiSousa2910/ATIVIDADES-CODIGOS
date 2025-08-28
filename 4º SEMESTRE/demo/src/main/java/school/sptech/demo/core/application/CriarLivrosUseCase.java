package school.sptech.demo.core.application;

import org.springframework.stereotype.Service;
import school.sptech.demo.core.adapter.LivroGateway;
import school.sptech.demo.core.application.command.CriarLivroCommand;
import school.sptech.demo.core.application.exception.DuplicidadeException;
import school.sptech.demo.core.domain.Livro;

public class CriarLivrosUseCase {

    private final LivroGateway gateway;

    public CriarLivrosUseCase(LivroGateway gateway) {
        this.gateway = gateway;
    }

    public Livro executar(CriarLivroCommand command){
        if (gateway.existePorIsbn(command.isbn())){
            throw new DuplicidadeException("Isbn já existe na base");
        }
        var livroDomain = new Livro();
        livroDomain.setTitulo(command.titulo());
        livroDomain.setIsbn(command.isbn());

        return gateway.cadastrar(livroDomain);
    }

}
