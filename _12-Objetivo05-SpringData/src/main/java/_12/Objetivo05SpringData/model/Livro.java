package _12.Objetivo05SpringData.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString

@Entity
public class Livro extends Exemplar {
    @Column(length = 50, nullable = false)
    private String autor;
    @Column(length = 50, nullable = false)
    private String editora;
    private Integer edicao;

    public Livro() {

    }
}
