package _12.Objetivo05SpringData.exemplares.artigos;

import _12.Objetivo05SpringData.exemplares.artigos.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

    @Query("SELECT a FROM Artigo a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Artigo> findByNome(String nome);
}
