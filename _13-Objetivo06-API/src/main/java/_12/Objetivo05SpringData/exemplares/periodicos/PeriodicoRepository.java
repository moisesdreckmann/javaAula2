package _12.Objetivo05SpringData.exemplares.periodicos;

import _12.Objetivo05SpringData.exemplares.periodicos.Periodico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeriodicoRepository extends JpaRepository<Periodico, Long> {

    @Query("SELECT a FROM Periodico a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Periodico> findByNome(String nome);
}
