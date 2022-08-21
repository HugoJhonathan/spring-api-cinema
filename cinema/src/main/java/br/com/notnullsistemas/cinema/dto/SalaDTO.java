package br.com.notnullsistemas.cinema.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaDTO implements Serializable {
    private Long id;
    private String nome;
    private Integer capacidade;
}
