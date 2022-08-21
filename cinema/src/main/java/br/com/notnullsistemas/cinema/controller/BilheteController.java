package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bilhetes")
public class BilheteController extends CrudController<Bilhete, BilheteDTO, Long> {


//    @GetMapping("/test")
//    public ResponseEntity<Object> test(){
//
//        var test = new Object();
//
//    }
}
