package school.sptech.demo.core.adapter;

import school.sptech.demo.core.domain.Livro;

public interface LivroGateway {
    Livro cadastrar(Livro domain);
    boolean existePorIsbn(String isbn);

}
