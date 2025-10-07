package school.sptech.exemplo_paginacao.entity.musica;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import school.sptech.exemplo_paginacao.entity.album.Album;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Musica {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @PositiveOrZero
    private Double duracao;

    @ManyToOne
    private Album album;
}