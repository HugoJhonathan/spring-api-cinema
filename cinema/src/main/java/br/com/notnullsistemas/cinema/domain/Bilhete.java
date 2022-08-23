package br.com.notnullsistemas.cinema.domain;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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

    private Date dataCompra;

    private LocalDate diaSessao;

    private Integer poltrona;

    private Boolean meia;

    private Double total;

    @ManyToOne
    @JsonIgnoreProperties("bilhetes")
    private Sessao sessao;

}
