package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.domain.Sala;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.RelatorioDiarioSalaDTO;
import br.com.notnullsistemas.cinema.dto.RelatorioSalaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private SalaService salaService;

    @Autowired
    private SessaoService sessaoService;

    public RelatorioDiarioSalaDTO relatorioSala(String de, String ate) {

        List<RelatorioSalaDTO> relatorioSalaDTOs = new ArrayList<>();
        RelatorioDiarioSalaDTO relatorioDiarioSalaDTO = new RelatorioDiarioSalaDTO();

        List<Sala> salas = salaService.listar();

        salas.stream().forEach(sala -> {
            List<Sessao> sessoes = sessaoService.listarSessoesDeUmaSala(sala.getId(), de, ate);

            Double faturamento = sessoes.stream()
                .map(sessao -> sessao.getTotal())
                .reduce(Double::sum)
                .orElse(0.00);

            Integer bilhetesVendido = sessoes.stream()
                	.map(sessao -> sessao.getBilhetes().size())
                    .reduce(Integer::sum)
                    .orElse(0);
            
            System.out.println(bilhetesVendido);

            RelatorioSalaDTO rel = new RelatorioSalaDTO();

            rel.setId(sala.getId());
            rel.setNome(sala.getNome());
            rel.setQdoSessoes(sessoes.size());
            rel.setFaturamento(faturamento);
            rel.setBilhetesVendidos(bilhetesVendido);
            
            sessoes.stream().forEach(sessao ->{
                 rel.addFilme(sessao.getFilme().getNome());
                 rel.addTipo(sessao.getTipo().getNome());
            });
            
            relatorioSalaDTOs.add(rel);
        });

        Double arrecadacaoTotal = relatorioSalaDTOs.stream()
                .map(sessao -> sessao.getFaturamento())
                .reduce(Double::sum)
                .orElse(0.00);

        Integer ocupacaoTotal = relatorioSalaDTOs.stream()
                .map(sessao -> sessao.getBilhetesVendidos())
                .reduce(Integer::sum)
                .orElse(0);

        Integer sessoesTotal = relatorioSalaDTOs.stream()
                .map(sessao -> sessao.getQdoSessoes())
                .reduce(Integer::sum)
                .orElse(0);

        relatorioDiarioSalaDTO.setSalas(relatorioSalaDTOs);
        relatorioDiarioSalaDTO.setArrecadaoTotal(arrecadacaoTotal);
        relatorioDiarioSalaDTO.setOcupacaoTotal(ocupacaoTotal);
        relatorioDiarioSalaDTO.setTotalSessoes(sessoesTotal);

        return relatorioDiarioSalaDTO;
    }

}
