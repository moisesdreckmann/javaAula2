package _12.Objetivo05SpringData.exemplares.periodicos;

import _12.Objetivo05SpringData.exemplares.Exemplar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Periodico extends Exemplar {
    @Column(length = 50, nullable = false)
    private String editora;

}
