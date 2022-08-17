package br.com.notnullsistemas.cinema.service;

import org.springframework.stereotype.Service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Sessao;

@Service
public class SessaoService extends CrudService<Sessao, Long> {

    @Override
    protected Sessao editarEntidade(Sessao recuperado, Sessao entidade) {
        return null;
    }
}
