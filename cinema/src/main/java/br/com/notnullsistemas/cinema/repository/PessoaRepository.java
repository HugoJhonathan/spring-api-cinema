package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    @Query("from Bilhete b join b.pessoa p where p.id=:id")
    List<Bilhete> bilhetesDeUmaPessoa(@Param("id") Long id);

    Optional<Pessoa> findByCpf(String cpf);


}
