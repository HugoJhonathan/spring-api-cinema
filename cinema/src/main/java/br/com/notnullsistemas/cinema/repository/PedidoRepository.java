package br.com.notnullsistemas.cinema.repository;

import br.com.notnullsistemas.cinema.core.crud.CrudRepository;
import br.com.notnullsistemas.cinema.domain.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    @Query("from Pedido p join p.pessoa pe where pe.id=:id")
    List<Pedido> pedidosDeUmaPessoa(@Param("id") Long id);

}
