package br.com.notnullsistemas.cinema.controller;

import br.com.notnullsistemas.cinema.core.crud.CrudController;
import br.com.notnullsistemas.cinema.domain.Pedido;
import br.com.notnullsistemas.cinema.dto.PedidoDTO;
import br.com.notnullsistemas.cinema.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends CrudController<Pedido, PedidoDTO, Long> {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<List<PedidoDTO>> pedidosDeUmaPessoa(@PathVariable Long id){
        var pedidos = pedidoRepository.pedidosDeUmaPessoa(id)
                .stream().map(converter::entidadeParaDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidos);
    }
}
