package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.SessaoDTO;
import br.com.notnullsistemas.cinema.repository.BilheteRepository;
import br.com.notnullsistemas.cinema.repository.SessaoRepository;
import br.com.notnullsistemas.cinema.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessoes")
public class SessaoController extends CrudController<Sessao, SessaoDTO, Long> {

    @Autowired
    private BilheteRepository bilheteRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private SessaoService sessaoService;

    @GetMapping("/{id}/{dia}")
    public ResponseEntity<SessaoDTO> sessaoDeUmDia(@PathVariable("id") Long id, @PathVariable("dia") String dia) throws Exception {
        LocalDate diaSessao = LocalDate.parse(dia);
        Sessao sessao = service.porId(id);

        if (diaSessao.isBefore(sessao.getDataInicio()) || diaSessao.isAfter(sessao.getDataFinal())) {
            throw new RuntimeException("Data inválida");
        }

        List<Bilhete> bilhetes = bilheteRepository.findByDiaSessaoAndSessaoId(diaSessao, id);
        sessao.setBilhetes(bilhetes);

        return ResponseEntity.ok(converter.entidadeParaDto(sessao));
    }


    @GetMapping("/pesquisa")
    public ResponseEntity<List<SessaoDTO>> listarTodos(
            @RequestParam(value = "horario", required = false) String horario,
            @RequestParam(value = "de", required = false) String de,
            @RequestParam(value = "ate", required = false) String ate) {

        List<SessaoDTO> sessoesDto = sessaoService.listarTodos(horario, de, ate)
                .stream().map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(sessoesDto);
    }


    @GetMapping("/filmes/{idFilme}/tipo/{idTipo}")
    public ResponseEntity<List<SessaoDTO>> listarSessoesDeUmDeterminadoFilmeEtipo(
            @PathVariable("idFilme") Long idFilme,
            @PathVariable("idTipo") Long idTipo) {

        List<SessaoDTO> sessoesDto = sessaoRepository.listarSessoesDeUmDeterminadoFilmeEtipo(idFilme, idTipo)
                .stream().map(converter::entidadeParaDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(sessoesDto);
    }


    @GetMapping("salas/{idSala}")
    public ResponseEntity<List<SessaoDTO>> listarSessoesDeUmaSala(
            @PathVariable("idSala") Long id,
            @RequestParam(value = "de", required = false) String de,
            @RequestParam(value = "ate", required = false) String ate) {

        List<SessaoDTO> sessoesDto = sessaoService.listarSessoesDeUmaSala(id, de, ate)
                .stream().map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(sessoesDto);
    }

}