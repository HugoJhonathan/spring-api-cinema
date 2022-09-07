package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Tipo;

import java.util.Optional;

public interface TipoRepository extends CrudRepository<Tipo, Long> {

    Optional<Tipo> findByNome(String nome);
}
