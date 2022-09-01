package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.core.exception.CinemaException;
import br.com.notnullsistemas.cinema.domain.Sala;
import br.com.notnullsistemas.cinema.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService extends CrudService<Sala, Long> {

    @Autowired
    private SalaRepository salaRepository;
    @Override
    protected void validar(Sala entidade) {
        boolean salaExiste = salaRepository.existsByNome(entidade.getNome());
        if(salaExiste){
            throw new CinemaException("Sala já cadastrada.");
        }
    }

    @Override
    protected void editarEntidade(Sala entidade, Sala recuperado) {
        recuperado.setId(entidade.getId());
        recuperado.setNome(entidade.getNome());
        recuperado.setCapacidade(entidade.getCapacidade());
    }


}
