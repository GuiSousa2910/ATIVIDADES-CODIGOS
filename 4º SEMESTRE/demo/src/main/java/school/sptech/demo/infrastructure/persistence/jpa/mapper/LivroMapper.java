package school.sptech.demo.infrastructure.persistence.jpa.mapper;

import org.springframework.stereotype.Component;
import school.sptech.demo.core.domain.Livro;
import school.sptech.demo.infrastructure.persistence.jpa.LivroEntity;

@Component
public class LivroMapper {
    public static LivroEntity toEntity(Livro domain){
        if (domain == null){
            return null;
        }else {
            LivroEntity entity = new LivroEntity();
            entity.setIsbn(domain.getIsbn());
            entity.setTitulo(domain.getTitulo());

            return entity;
        }
    }

    public static Livro toDomain(LivroEntity entity){
        if (entity == null){
            return null;
        }

        Livro domain = new Livro();
        domain.setId(entity.getId());
        domain.setTitulo(entity.getTitulo());
        domain.setIsbn(entity.getIsbn());

        return domain;

    }
}
