package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

//    @Query("from Bilhete b join b.pessoa p where p.id=:id")
//    List<Bilhete> bilhetesDeUmaPessoa(@Param("id") Long id);

    Optional<Pessoa> findByCpf(String cpf);


    boolean existsByCpf(String cpf);
}
