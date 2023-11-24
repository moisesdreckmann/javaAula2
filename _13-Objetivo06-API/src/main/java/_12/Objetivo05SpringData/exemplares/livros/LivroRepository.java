package _12.Objetivo05SpringData.exemplares.livros;

import _12.Objetivo05SpringData.exemplares.livros.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT a FROM Livro a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Livro> findByNome(String nome);
}
