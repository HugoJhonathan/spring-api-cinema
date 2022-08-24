package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.SessaoDTO;
import br.com.notnullsistemas.cinema.repository.BilheteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessoes")
public class SessaoController extends CrudController<Sessao, SessaoDTO, Long> {

    @Autowired
    private BilheteRepository bilheteRepository;

    @GetMapping("/{id}/{dia}")
    public ResponseEntity<SessaoDTO> sessaoDeUmDia(@PathVariable("id") Long id, @PathVariable("dia") String dia) {
        LocalDate diaSessao = LocalDate.parse(dia);
        Sessao sessao = service.porId(id);

        if (diaSessao.isBefore(sessao.getDataInicio()) || diaSessao.isAfter(sessao.getDataFinal())) {
            throw new RuntimeException("Data inválida");
        }

        var bilhetes = bilheteRepository.findByDiaSessaoAndSessaoId(diaSessao, id);
        sessao.setBilhetes(bilhetes);

        return ResponseEntity.ok(converter.entidadeParaDto(sessao));
    }

    @GetMapping("/pesquisa")
    public ResponseEntity<List<SessaoDTO>> listarTodos(@RequestParam(value = "de", required = false) String de, @RequestParam(value = "ate", required = false) String ate) {
        var de_ = LocalDate.parse(de);
        var ate_ = LocalDate.parse(ate);

        if (!Objects.isNull(de)) {

            if (Objects.isNull(ate)) {
                ate = de;
            }

            var sessoes = service.findByInterval(de, ate);

            sessoes.stream().forEach(sessao -> {
                sessao.setBilhetes(bilheteRepository
                        .procurarBilheteDeUmaSessaoPorIntervalo(de_, ate_, sessao.getId()));
            });

            List<SessaoDTO> entidades = service.findByInterval(de, ate)
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

}
