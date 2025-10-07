package school.sptech.exemplo_curso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.rmi.server.UID;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String ra;

    @ManyToOne
    private Curso curso;
}
