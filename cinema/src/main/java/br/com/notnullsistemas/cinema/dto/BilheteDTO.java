package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BilheteDTO implements Serializable {


    private Long id;
    @NotNull
    private Integer poltrona;
    @NotNull
    private Boolean meia;
    
    private Double total;
    private Date dataCompra;

    @NotNull
    private LocalDate diaSessao;
    private LocalTime horarioSessao;

    @NotNull
    private PessoaDTO pessoa;
    @NotNull
    private Long sessaoId;
    private SessaoMinDTO sessao;

}