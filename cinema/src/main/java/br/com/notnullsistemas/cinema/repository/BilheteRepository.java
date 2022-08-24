package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Bilhete;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BilheteRepository extends CrudRepository<Bilhete, Long> {

    List<Bilhete> findByDiaSessaoAndSessaoId(LocalDate diaSessao, Long id);

    @Query("from Bilhete b where b.diaSessao between :de AND :ate")
    List<Bilhete> procurarBilhetePorIntervalo(@Param("de") LocalDate de, @Param("ate") LocalDate ate);

    @Query(value = "select * from bilhetes where (bilhetes.sessao_id = :sessaoID) AND (bilhetes.dia_sessao between :de AND :ate)", nativeQuery = true)
    List<Bilhete> procurarBilheteDeUmaSessaoPorIntervalo(@Param("de") LocalDate de, @Param("ate") LocalDate ate, @Param("sessaoID") Long id);

}
