package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmeDTO implements Serializable {
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private Integer duracao;
    @NotBlank
    private String generos;
    @NotBlank
    private String diretor;
    @NotBlank
    private String sinopse;
    @NotBlank
    private String atores;
    private String posterUrl;
    private String bannerUrl;
}
