package br.com.notnullsistemas.cinema.repository;

import org.springframework.stereotype.Repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Sessao;

@Repository
public interface SessaoRepository extends CrudRepository<Sessao, Long> {

}
