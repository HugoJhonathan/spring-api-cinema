package br.com.notnullsistemas.cinema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

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

    @Transient
    private Double total;

    @Transient
    private List<Integer> ocupadas;

    public List<Integer> getOcupadas() {

        ocupadas = new ArrayList<>();

        for(Bilhete bilhete : getBilhetes()){
            ocupadas.add(bilhete.getPoltrona());
        }
        return ocupadas;
    }

    public Double getTotal() {
        Double total = 0.0;
        for(Bilhete bilhete : getBilhetes()){
            if(bilhete.getMeia()){
                total += getTipo().getPreco()/2;
            }else{
                total += getTipo().getPreco();
            }
        }
        return total;
    }
}
