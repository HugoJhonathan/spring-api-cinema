package br.com.notnullsistemas.cinema.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Bilhete;

@RestController
@RequestMapping("/bilhetes")
public class BilheteController extends CrudController<Bilhete, Long> {

}
