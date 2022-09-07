package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends CrudService<Pedido, Long> {


    @Override
    protected void validar(Pedido entidade) throws Exception {

    }

    @Override
    protected void editarEntidade(Pedido entidade, Pedido recuperado) {

    }
}
