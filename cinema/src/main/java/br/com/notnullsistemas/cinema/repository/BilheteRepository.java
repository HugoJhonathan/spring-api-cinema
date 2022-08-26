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

    @Query("from Bilhete b join b.sessao s join s.tipo t where t.id = :id")
    List<Bilhete> buscarPorTipo(@Param("id") Long id);

    @Query("from Bilhete b join b.sessao s join s.tipo t where (t.id = :id) and (b.diaSessao between :de AND :ate)")
    List<Bilhete> buscarPorTipoData(@Param("id") Long id, @Param("de") LocalDate de, @Param("ate") LocalDate ate);
}
