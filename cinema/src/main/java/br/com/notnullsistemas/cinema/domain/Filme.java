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
@Table(name = "filmes")
public class Filme implements Serializable, CrudDomain<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String nome;
    private Integer duracao;
    private String generos;
    private String diretor;
    @Column(unique=true)
    private String sinopse;
    private String atores;
    private String posterUrl;
    private String bannerUrl;

}
