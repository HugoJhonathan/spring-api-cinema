package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BilheteRepository extends CrudRepository<Bilhete, Long> {

    List<Bilhete> findByDiaSessaoAndSessaoId(LocalDate diaSessao, Long id);

}
