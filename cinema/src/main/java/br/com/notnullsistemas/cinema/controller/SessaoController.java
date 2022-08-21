package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.dto.SessaoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Sessao;

@RestController
@RequestMapping("/sessoes")
public class SessaoController extends CrudController<Sessao, SessaoDTO, Long> {

}
