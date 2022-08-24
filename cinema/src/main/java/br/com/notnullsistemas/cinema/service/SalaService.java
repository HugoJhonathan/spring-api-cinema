package br.com.notnullsistemas.cinema.service;

import org.springframework.stereotype.Service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Sala;

import java.util.List;

@Service
public class SalaService extends CrudService<Sala, Long> {

    @Override
    protected Sala editarEntidade(Sala recuperado, Sala entidade) {
        return null;
    }

    @Override
    public List<Sala> findByInterval(String de, String ate) {
        return null;
    }


}
