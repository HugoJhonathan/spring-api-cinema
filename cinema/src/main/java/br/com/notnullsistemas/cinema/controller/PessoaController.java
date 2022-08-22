package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.converter.BilheteConverter;
import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import br.com.notnullsistemas.cinema.dto.PessoaDTO;
import br.com.notnullsistemas.cinema.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaController extends CrudController<Pessoa, PessoaDTO, Long> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BilheteConverter bilheteConverter;

    @GetMapping("/{id}/bilhetes")
    public ResponseEntity<List<BilheteDTO>> getBilhetesDeUmaPessoa(@PathVariable("id") Long id){
        List<Bilhete> bilhetes = pessoaRepository.bilhetesDeUmaPessoa(id);
        List<BilheteDTO> bilhetesDTO = bilhetes.stream()
                .map(bilheteConverter::entidadeParaDto)
                .collect(Collectors.toList());

       return ResponseEntity.ok(bilhetesDTO);
    }

}
