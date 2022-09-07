package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.core.exception.CinemaException;
import br.com.notnullsistemas.cinema.domain.Tipo;
import br.com.notnullsistemas.cinema.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoService extends CrudService<Tipo, Long> {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    protected void validar(Tipo entidade) {
        Optional<Tipo> tipo = tipoRepository.findByNome(entidade.getNome());

        if(tipo.isPresent() && !tipo.get().getId().equals(entidade.getId())){
            throw new CinemaException("Já existe um Tipo cadastrada com esse nome!");
        }
    }

    @Override
    protected void editarEntidade(Tipo entidade, Tipo recuperado) {
        recuperado.setNome(entidade.getNome());
        recuperado.setPreco(entidade.getPreco());
    }

}
