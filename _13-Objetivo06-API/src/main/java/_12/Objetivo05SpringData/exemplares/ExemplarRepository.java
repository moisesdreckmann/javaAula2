package _12.Objetivo05SpringData.exemplares;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {

}
