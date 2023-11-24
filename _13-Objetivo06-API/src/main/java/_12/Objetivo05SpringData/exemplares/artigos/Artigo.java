package _12.Objetivo05SpringData.exemplares.artigos;

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
public class Artigo extends Exemplar {
    @Column(length = 50, nullable = false)
    private String autor;

}
