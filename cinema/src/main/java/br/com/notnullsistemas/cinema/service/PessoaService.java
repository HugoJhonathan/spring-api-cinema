package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends CrudService<Pessoa, Long> {
    @Override
    protected Pessoa editarEntidade(Pessoa recuperado, Pessoa entidade) {
        return null;
    }
}
