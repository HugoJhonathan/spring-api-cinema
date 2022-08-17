package br.com.notnullsistemas.cinema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sessoes")
public class Sessao implements Serializable, CrudDomain<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("sessoes")
    private Sala sala;

    private Date horario;

    @ManyToOne
    @JsonIgnoreProperties("sessoes")
    private Filme filme;

    @ManyToOne
    @JsonIgnoreProperties("sessao")
    private Tipo tipo;

    @OneToMany(mappedBy = "sessao")
    @JsonIgnoreProperties("sessao")
    private List<Bilhete> bilhetes = new ArrayList<>();

}
