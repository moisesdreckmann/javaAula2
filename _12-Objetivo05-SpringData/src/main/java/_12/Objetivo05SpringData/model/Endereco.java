package _12.Objetivo05SpringData.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString

@Embeddable
@Table(name = "enderecoAluno")
public class Endereco {
    @Column(length = 30, nullable = false)
    private String rua;
    @Column(length = 8, nullable = false)
    private Integer numero;
    @Column(length = 10, nullable = false)
    private String cep;

    public Endereco() {

    }
}
