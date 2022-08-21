package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bilhetes")
public class BilheteController extends CrudController<Bilhete, Bilhete, Long> {

}
