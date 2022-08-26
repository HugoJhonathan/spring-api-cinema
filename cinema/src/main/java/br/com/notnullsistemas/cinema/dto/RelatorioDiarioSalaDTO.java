package br.com.notnullsistemas.cinema.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RelatorioDiarioSalaDTO implements Serializable {
    private List<RelatorioSalaDTO> salas;
    private Double arrecadaoTotal;
    private Integer ocupacaoTotal;
    private Integer totalSessoes;
}