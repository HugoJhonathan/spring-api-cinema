package br.com.notnullsistemas.cinema.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BilheteDTO implements Serializable {

    private Long id;
    private Integer poltrona;
    private Boolean meia;
    private Double total;
    private PessoaDTO pessoa;
    private Integer pessoaId;
    private Integer sessaoId;
}