package br.com.notnullsistemas.cinema.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sessoes")
public class Sessao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Filme filme;
    @ManyToOne
    private Sala sala;
    @ManyToOne
    private Tipo tipo;

    private Date horario;
    private List<Integer> disponivel;
    private Double valorTotal;

}
