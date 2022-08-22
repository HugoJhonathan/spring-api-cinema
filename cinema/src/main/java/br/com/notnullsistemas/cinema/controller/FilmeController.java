package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Filme;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.FilmeDTO;
import br.com.notnullsistemas.cinema.repository.FilmeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController extends CrudController<Filme, FilmeDTO, Long> {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/{id}/sessoes")
    public ResponseEntity<List<Sessao>> listarSessoes(@PathVariable("id") Long id) {

        List<Sessao> listarSessoes = filmeRepository.sessoesPorFilme(id);

        return ResponseEntity.ok(listarSessoes);
    }
}
