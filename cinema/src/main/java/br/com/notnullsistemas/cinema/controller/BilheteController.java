package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bilhetes")
public class BilheteController extends CrudController<Bilhete, BilheteDTO, Long> {

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
    public ResponseEntity<List<BilheteDTO>> bilhetesPorFilme(@PathVariable("id") Long id){
        var ListaDto = service.listar()
                .stream()
                .map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ListaDto);
    }
}
