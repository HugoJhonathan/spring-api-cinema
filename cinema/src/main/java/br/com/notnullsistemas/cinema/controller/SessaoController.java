package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.SessaoDTO;
import br.com.notnullsistemas.cinema.repository.BilheteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/sessoes")
public class SessaoController extends CrudController<Sessao, SessaoDTO, Long> {

    @Autowired
    private BilheteRepository bilheteRepository;

    @GetMapping("/{id}/{dia}")
    public ResponseEntity<SessaoDTO> sessaoDeUmDia(@PathVariable("id") Long id, @PathVariable("dia") String dia){
        LocalDate diaSessao = LocalDate.parse(dia);
        Sessao sessao = service.porId(id);

        if(diaSessao.isBefore(sessao.getDataInicio()) || diaSessao.isAfter(sessao.getDataFinal())){
            throw new RuntimeException("Data inválida");
        }

        var bilhetes= bilheteRepository.findByDiaSessaoAndSessaoId(diaSessao, id);
        sessao.setBilhetes(bilhetes);

        return ResponseEntity.ok(converter.entidadeParaDto(sessao));
    }

}
