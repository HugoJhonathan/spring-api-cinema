package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Sessao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface SessaoRepository extends CrudRepository<Sessao, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM sessoes WHERE horario =:horario AND sala_id =:sala AND ativo = 1")
    Sessao sessaoAtiva(@Param("horario") LocalTime horario, @Param("sala") Long sala);

    @Query("from Sessao s where (s.dataInicio between :de AND :ate) OR (s.dataFinal between :de AND :ate) OR s.dataInicio <= :de AND s.dataFinal >= :de")
    List<Sessao> procurarSessaoPorIntervalo(@Param("de") LocalDate de, @Param("ate") LocalDate ate);

}
