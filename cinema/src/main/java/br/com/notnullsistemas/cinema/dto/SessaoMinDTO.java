package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoMinDTO implements Serializable {
    private Long id;
    private Date horario;
    private Double total;
    private SalaDTO sala;
    private FilmeDTO filme;
    private TipoDTO tipo;
}
