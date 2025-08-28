package school.sptech.demo.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import school.sptech.demo.core.application.CriarLivrosUseCase;
import school.sptech.demo.infrastructure.persistence.jpa.LivroJpaAdapter;

@Configuration
public class LivroBeanConfig {

    @Bean
    public CriarLivrosUseCase criarLivrosUseCase(LivroJpaAdapter adapter){
        return new CriarLivrosUseCase(adapter);
    }
}
