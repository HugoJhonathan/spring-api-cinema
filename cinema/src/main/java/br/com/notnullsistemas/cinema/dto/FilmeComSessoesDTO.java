package br.com.notnullsistemas.cinema.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmeComSessoesDTO implements Serializable {
    private FilmeDTO filme;
    @JsonIgnoreProperties("filme")
    private Set<SessaoMinDTO> sessaoAtiva = new HashSet<>();
}
