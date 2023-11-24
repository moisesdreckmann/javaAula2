package _12.Objetivo05SpringData.emprestimos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("SELECT e FROM Emprestimo e WHERE e.aluno.codigo = :codigoDoAluno")
    List<Emprestimo> findByCodigoDoAluno(@Param("codigoDoAluno") Long codigoDoAluno);
}
