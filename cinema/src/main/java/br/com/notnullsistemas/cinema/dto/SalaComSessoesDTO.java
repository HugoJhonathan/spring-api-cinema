package br.com.notnullsistemas.cinema.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaComSessoesDTO implements Serializable {

    private SalaDTO sala;
    @JsonIgnoreProperties("filme")
    private List<SessaoMinDTO> sessoes = new ArrayList<>();

}
