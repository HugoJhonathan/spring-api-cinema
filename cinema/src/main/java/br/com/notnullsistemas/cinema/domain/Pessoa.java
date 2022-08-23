package br.com.notnullsistemas.cinema.domain;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pessoas")
public class Pessoa implements Serializable, CrudDomain<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique=true)
    private String cpf;

}