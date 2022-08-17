package br.com.notnullsistemas.cinema.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "salas")
public class Sala implements Serializable, CrudDomain<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer capacidade;

    @OneToMany(mappedBy = "sala")
    private List<Sessao> sessoes;
}
