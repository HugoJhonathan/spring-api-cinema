package br.com.notnullsistemas.cinema.service;

import org.springframework.stereotype.Service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Tipo;

import java.util.List;

@Service
public class TipoService extends CrudService<Tipo, Long> {

    @Override
    protected Tipo editarEntidade(Tipo recuperado, Tipo entidade) {
        return null;
    }

    @Override
    public List<Tipo> findByInterval(String de, String ate) {
        return null;
    }


}
