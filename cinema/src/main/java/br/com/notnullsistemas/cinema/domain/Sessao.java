package br.com.notnullsistemas.cinema.domain;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    private LocalTime horario;

    private LocalDate dataInicio;
    private LocalDate dataFinal;

    private Boolean ativo = true;

    @ManyToOne
    @JsonIgnoreProperties("sessoes")
    private Filme filme;

    @ManyToOne
    @JsonIgnoreProperties("sessao")
    private Tipo tipo;

    @OneToMany(mappedBy = "sessao")
    @JsonIgnoreProperties("sessao")
    private List<Bilhete> bilhetes = new ArrayList<>();

    @Transient
    private Double total;

    @Transient
    private List<Integer> ocupadas;

    public List<Integer> getOcupadas() {

        ocupadas = new ArrayList<>();

        for (Bilhete bilhete : getBilhetes()) {
            ocupadas.add(bilhete.getPoltrona());
        }
        return ocupadas;
    }

    public Double getTotal() {
        Double total = 0.0;
        for (Bilhete bilhete : bilhetes) {
            if (bilhete.getMeia()) {
                total += getTipo().getPreco() / 2;
            } else {
                total += getTipo().getPreco();
            }
        }
        return total;
    }
}
