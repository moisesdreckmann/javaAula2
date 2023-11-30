package _12.Objetivo05SpringData.alunos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

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

    @Override
    public String toString() {
        return "\nAluno{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
