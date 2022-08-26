package br.com.notnullsistemas.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.notnullsistemas.cinema.dto.RelatorioDiarioSalaDTO;
import br.com.notnullsistemas.cinema.service.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController{

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/salas")
    public ResponseEntity<RelatorioDiarioSalaDTO> relatorioSala(
        @RequestParam(value = "de", required = false) String de,
        @RequestParam(value = "ate", required = false) String ate){

        return ResponseEntity.ok(relatorioService.relatorioSala(de, ate));
    }
}
