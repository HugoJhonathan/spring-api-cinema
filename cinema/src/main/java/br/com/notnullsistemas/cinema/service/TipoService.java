package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Tipo;
import org.springframework.stereotype.Service;

@Service
public class TipoService extends CrudService<Tipo, Long> {

    @Override
    protected void validar(Tipo entidade) {

    }

    @Override
    protected void editarEntidade(Tipo recuperado, Tipo entidade) {

    }

}
