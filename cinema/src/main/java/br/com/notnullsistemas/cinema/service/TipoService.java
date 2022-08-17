package br.com.notnullsistemas.cinema.service;

import org.springframework.stereotype.Service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Tipo;

@Service
public class TipoService extends CrudService<Tipo, Long> {

    @Override
    protected Tipo editarEntidade(Tipo recuperado, Tipo entidade) {
        return null;
    }

}
