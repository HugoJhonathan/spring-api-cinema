package br.com.notnullsistemas.cinema.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoDTO implements Serializable {
    private Long id;
    private Date horario;
    private SalaDTO sala;
    private FilmeDTO filme;
    private TipoDTO tipo;
    private Integer filmeId;
    private Integer salaId;
    private Integer tipoId;
    private Double total;
}
