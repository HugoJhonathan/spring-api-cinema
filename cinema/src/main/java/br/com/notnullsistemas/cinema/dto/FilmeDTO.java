package br.com.notnullsistemas.cinema.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmeDTO implements Serializable {
    private Long id;
    private String nome;
    private Integer duracao;
    private String generos;
    private String diretor;
    private String sinopse;
    private String atores;
}
