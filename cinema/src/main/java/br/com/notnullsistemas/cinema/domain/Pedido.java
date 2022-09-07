package br.com.notnullsistemas.cinema.domain;

import br.com.notnullsistemas.cinema.core.crud.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pedidos")
public class Pedido implements Serializable, CrudDomain<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;

    @ManyToOne
    @JsonIgnoreProperties("pedidos")
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(
            name = "item_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "bilhete_id")
    )
    private List<Bilhete> bilhetes = new ArrayList<>();
}
