package br.com.notnullsistemas.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RelatorioSalaDTO implements Serializable {
    private Long id;
    private String nome;
    @JsonProperty("bilhetes_vendidos")
    private Integer bilhetesVendidos;
    private Double faturamento;
    @JsonProperty("qtd_sessoes")
    private Integer qdoSessoes;
    private Set<String> filmes = new HashSet<>();
    private Set<String> tipos = new HashSet<>();

    public void addFilme(String filme){
        filmes.add(filme);
    }
    
    public void addTipo(String tipo){
        tipos.add(tipo);
    }
}