package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.dto.SalaDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Sala;

@RestController
@RequestMapping("/salas")
public class SalaController extends CrudController<Sala, SalaDTO, Long> {

}
