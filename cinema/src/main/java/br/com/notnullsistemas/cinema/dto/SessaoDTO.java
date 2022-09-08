package br.com.notnullsistemas.cinema.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @NotNull
    private Boolean ativo;
    @NotNull
    private Long filmeId;
    @NotNull
    private Long salaId;
    @NotNull
    private Long tipoId;
    @NotNull
    private SalaDTO sala;
    @NotNull
    private FilmeDTO filme;
    @NotNull
    private TipoDTO tipo;
    private List<BilheteMinDTO> bilhetes;
    private List<Integer> ocupadas;
}
