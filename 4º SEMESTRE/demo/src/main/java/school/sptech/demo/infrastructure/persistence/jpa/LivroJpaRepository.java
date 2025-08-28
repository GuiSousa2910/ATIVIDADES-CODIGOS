package school.sptech.demo.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroJpaRepository extends JpaRepository<LivroEntity, Integer> {

    boolean existsByIsbn(String isbn);
}
