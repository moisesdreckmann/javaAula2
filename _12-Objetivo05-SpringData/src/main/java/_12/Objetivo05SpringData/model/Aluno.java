package _12.Objetivo05SpringData.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 10, nullable = false)
    private LocalDate dataNascimento;
    private Integer telefone;
    @Column(length = 20, nullable = false)
    private String email;
    @Embedded
    private Endereco endereco;
    public Aluno() {

    }
}
