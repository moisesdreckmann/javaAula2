package _12.Objetivo05SpringData.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "exemplares")
abstract class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 30, nullable = false)
    private String nome;
    @Column(length = 1, nullable = false)
    private Integer tipoExemplar;


    public Exemplar() {

    }
}
