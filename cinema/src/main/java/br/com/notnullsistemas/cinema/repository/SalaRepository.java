package br.com.notnullsistemas.cinema.repository;

import org.springframework.stereotype.Repository;
import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Sala;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long> {

    boolean existsByNome(String nome);
}
