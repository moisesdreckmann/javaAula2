package _12.Objetivo05SpringData.emprestimos;

import _12.Objetivo05SpringData.alunos.Aluno;
import _12.Objetivo05SpringData.exemplares.Exemplar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Table(name = "emprestimos")
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    @Column(length = 8, nullable = false)
    private LocalDate dataEmprestimo;
    @Column(length = 8, nullable = false)
    private LocalDate dataDevolucao;
    @OneToOne
    private Aluno aluno;
    @OneToOne
    private Exemplar exemplar;

}

