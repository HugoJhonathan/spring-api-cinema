package br.com.notnullsistemas.cinema.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoDTO implements Serializable {
    private Long id;
    @NotNull
    private LocalTime horario;
    @NotNull
    private LocalDate dataInicio;
    @NotNull
    private LocalDate dataFinal;
    private Double total;
    private Boolean ativo;
    @NotNull
    private Long filmeId;
    @NotNull
    private Long salaId;
    @NotNull
    private Long tipoId;

    private SalaDTO sala;

    private FilmeDTO filme;

    private TipoDTO tipo;
    private List<BilheteMinDTO> bilhetes;
    private List<Integer> ocupadas;
}
