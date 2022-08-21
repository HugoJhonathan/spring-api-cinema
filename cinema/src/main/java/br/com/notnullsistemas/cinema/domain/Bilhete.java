package br.com.notnullsistemas.cinema.domain;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "bilhetes")
public class Bilhete implements Serializable, CrudDomain<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("bilhetes")
    private Pessoa pessoa;

    private Integer poltrona;

    private Boolean meia;

    private Double total;

}
