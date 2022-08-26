package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import br.com.notnullsistemas.cinema.repository.FilmeRepository;
import br.com.notnullsistemas.cinema.service.BilheteService;
import br.com.notnullsistemas.cinema.service.FilmeService;
import br.com.notnullsistemas.cinema.service.SessaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bilhetes")
public class BilheteController extends CrudController<Bilhete, BilheteDTO, Long> {

    @Autowired
    private FilmeService filmeService;
    @Autowired
    private BilheteService bilheteService;
    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/pesquisa")
    public ResponseEntity<List<BilheteDTO>> listarTodos(@RequestParam(value = "de", required = false) String de,
            @RequestParam(value = "ate", required = false) String ate) {

        if (!Objects.isNull(de)) {
            if (Objects.isNull(ate)) {
                ate = de;
            }

            List<BilheteDTO> entidades = service.findByInterval(de, ate)
                    .stream()
                    .map(converter::entidadeParaDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(entidades);
        }

        var ListaDto = service.listar()
                .stream()
                .map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ListaDto);
    }

    @GetMapping("/filme/{id}")
    public ResponseEntity<List<BilheteDTO>> bilhetesPorFilme(@PathVariable("id") Long id,
            @RequestParam(value = "de", required = false) String de,
            @RequestParam(value = "ate", required = false) String ate) {

        List<Sessao> sessoes = filmeRepository.sessoesPorFilme(id);

        List<Bilhete> listaBilhetes = bilheteService.buscarBilhetesEmSessoes(sessoes, de, ate);

        List<BilheteDTO> entidades = listaBilhetes.stream()
                .map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(entidades);

    }

    @GetMapping("/tipo/{id}")
    public ResponseEntity<List<BilheteDTO>> bilhetesPorTipo(@PathVariable("id") Long id,
            @RequestParam(value = "de", required = false) String de,
            @RequestParam(value = "ate", required = false) String ate) {

        List<Bilhete> listaBilhetes = bilheteService.bilhetesPorTipo(id, de, ate);

        List<BilheteDTO> entidades = listaBilhetes.stream()
                .map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(entidades);
    }

    @GetMapping("/sessao/{id}")
    public ResponseEntity<List<BilheteDTO>> bilhetesPorSessao(@PathVariable("id") Long id,
            @RequestParam(value = "de", required = false) String de,
            @RequestParam(value = "ate", required = false) String ate) {
        Sessao sessao = sessaoService.porId(id);

        List<Bilhete> listaBilhetes = bilheteService.bilhetesPorSessao(sessao, de, ate);

        List<BilheteDTO> entidades = listaBilhetes.stream()
                .map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(entidades);
    }
}
