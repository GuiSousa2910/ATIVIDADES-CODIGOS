package school.sptech.demo.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import school.sptech.demo.core.adapter.LivroGateway;
import school.sptech.demo.core.domain.Livro;
import school.sptech.demo.infrastructure.persistence.jpa.mapper.LivroMapper;

@Repository
public class LivroJpaAdapter implements LivroGateway {

    private final LivroJpaRepository repository;
    private final LivroMapper mapper;

    public LivroJpaAdapter(LivroJpaRepository repository, LivroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Livro cadastrar(Livro domain) {
        LivroEntity livroParaRegistro = mapper.toEntity(domain);

        LivroEntity entityCadastrada = repository.save(livroParaRegistro);

        Livro dominio = mapper.toDomain(entityCadastrada);

        return dominio;
    }

    @Override
    public boolean existePorIsbn(String isbn) {
        return repository.existsByIsbn(isbn);
    }
}
