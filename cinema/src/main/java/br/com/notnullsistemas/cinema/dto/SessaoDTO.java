package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoDTO implements Serializable {
    private Long id;
    private Date horario;
    private Double total;
    private Long filmeId;
    private Long salaId;
    private Long tipoId;
    private SalaDTO sala;
    private FilmeDTO filme;
    private TipoDTO tipo;
    private List<BilheteMinDTO> bilhetes;
}
