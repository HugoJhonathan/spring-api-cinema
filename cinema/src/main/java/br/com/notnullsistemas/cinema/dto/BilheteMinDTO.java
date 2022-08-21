package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BilheteMinDTO implements Serializable {

    private Long id;
    private Integer poltrona;
    private Boolean meia;
    private Double total;
    private PessoaDTO pessoa;
    private Long pessoaId;
    private Long sessaoId;

}