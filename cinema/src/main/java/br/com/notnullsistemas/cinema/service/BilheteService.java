package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Filme;
import org.springframework.stereotype.Service;

@Service
public class BilheteService extends CrudService<Bilhete, Long> {
    @Override
    protected Bilhete editarEntidade(Bilhete recuperado, Bilhete entidade) {
        return null;
    }
}
