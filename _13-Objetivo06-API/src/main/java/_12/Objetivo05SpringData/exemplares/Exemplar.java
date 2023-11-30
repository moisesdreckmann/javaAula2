package _12.Objetivo05SpringData.exemplares;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "exemplares")
public abstract class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 30, nullable = false)
    private String nome;
    @Column(length = 1, nullable = false)
    private Integer tipoExemplar;

    @Override
    public String toString() {
        return "\nExemplar{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", tipoExemplar=" + tipoExemplar +
                '}';
    }
}
