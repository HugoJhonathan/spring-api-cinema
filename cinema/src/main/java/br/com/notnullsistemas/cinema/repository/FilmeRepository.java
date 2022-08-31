package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Filme;
import br.com.notnullsistemas.cinema.domain.Sessao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Long> {

    @Query(value = "FROM Sessao s JOIN s.filme f WHERE f.id = :id")
    List<Sessao> sessoesPorFilme(@Param("id") Long id);

//    @Query(value = "FROM Sessao s JOIN s.filme f WHERE f.id = :id")
//    List<Filme> filmesAtivos();


    boolean existsByNome(String nome);
}
