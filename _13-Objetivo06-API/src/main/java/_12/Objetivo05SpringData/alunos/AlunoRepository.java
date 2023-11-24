package _12.Objetivo05SpringData.alunos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Aluno> findByNome(String nome);
}
