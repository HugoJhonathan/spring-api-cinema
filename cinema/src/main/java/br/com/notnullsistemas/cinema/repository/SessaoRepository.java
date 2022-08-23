package br.com.notnullsistemas.cinema.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Sessao;

@Repository
public interface SessaoRepository extends CrudRepository<Sessao, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM sessoes WHERE horario =:horario AND sala_id =:sala AND ativo = 1;")
    Sessao sessaoAtiva(@Param("horario") LocalTime horario, @Param("sala") Long sala);
}
