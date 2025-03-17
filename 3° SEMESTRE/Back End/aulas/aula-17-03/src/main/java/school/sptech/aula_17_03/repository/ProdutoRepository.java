package school.sptech.aula_17_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.aula_17_03.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByCodigoIgnoreCase(String codigo);
}
