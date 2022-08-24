package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService extends CrudService<Filme, Long> {
    @Override
    protected Filme editarEntidade(Filme recuperado, Filme entidade) {
        return null;
    }

    @Override
    public List<Filme> findByInterval(String de, String ate) {
        return null;
    }


}
