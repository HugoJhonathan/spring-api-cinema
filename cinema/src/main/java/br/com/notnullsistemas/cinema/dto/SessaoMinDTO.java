package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoMinDTO implements Serializable {
    private Long id;
    private LocalTime horario;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Double total;
    private Boolean ativo;
    private SalaDTO sala;
    private FilmeDTO filme;
    private TipoDTO tipo;
}
