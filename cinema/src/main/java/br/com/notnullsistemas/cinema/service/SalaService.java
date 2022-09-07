package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.core.exception.CinemaException;
import br.com.notnullsistemas.cinema.domain.Sala;
import br.com.notnullsistemas.cinema.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaService extends CrudService<Sala, Long> {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    protected void validar(Sala entidade) {

        Optional<Sala> sala = salaRepository.findByNome(entidade.getNome());

        if(sala.isPresent() && !sala.get().getId().equals(entidade.getId())){
            throw new CinemaException("Já existe uma Sala cadastrada com esse nome!");
        }
    }

    @Override
    protected void editarEntidade(Sala entidade, Sala recuperado) {

        recuperado.setNome(entidade.getNome());
        recuperado.setCapacidade(entidade.getCapacidade());
    }


}
