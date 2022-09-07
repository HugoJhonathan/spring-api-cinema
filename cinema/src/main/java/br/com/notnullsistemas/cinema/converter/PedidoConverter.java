package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pedido;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import br.com.notnullsistemas.cinema.dto.PedidoDTO;
import br.com.notnullsistemas.cinema.service.BilheteService;
import br.com.notnullsistemas.cinema.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PedidoConverter implements CrudConverter<Pedido, PedidoDTO> {

    private final PessoaService pessoaService;
    private final BilheteService bilheteService;
    private final BilheteConverter bilheteConverter;
    private final PessoaConverter pessoaConverter;

    @Override
    public PedidoDTO entidadeParaDto(Pedido entidade) {

        var valorTotal = entidade.getBilhetes().stream()
                .map(item ->item.getTotal())
                .reduce(Double::sum)
                .orElse(0.0);

        PedidoDTO pedido = new PedidoDTO();
        pedido.setId(entidade.getId());
        pedido.setPessoaId(entidade.getPessoa().getId());
        pedido.setBilhetes(entidade.getBilhetes().stream().map(bilheteConverter::entidadeParaDto).collect(Collectors.toList()));
        pedido.setPessoa(pessoaConverter.entidadeParaDto(entidade.getPessoa()));
        pedido.setTotal(valorTotal);
        return pedido;
    }

    @Override
    public Pedido dtoParaEntidade(PedidoDTO dto) throws Exception {

        Pessoa pessoa = pessoaService.findByCpf(dto.getPessoa().getCpf());

        if (Objects.isNull(pessoa)) {
            pessoa = pessoaService.criar(pessoaConverter.dtoParaEntidade(dto.getPessoa()));
        }

        List<Bilhete> bilhetes = new ArrayList<>();
        for (BilheteDTO bilheteDTO : dto.getBilhetes()) {
            Bilhete dtoParaEntidade = bilheteConverter.dtoParaEntidade(bilheteDTO);
            bilhetes.add(dtoParaEntidade);
        }

        List<Bilhete> list = new ArrayList<>();
        for (Bilhete bilhete : bilhetes) {
            Bilhete criar = bilheteService.criar(bilhete);
            list.add(criar);
        }

        Pedido pedido = new Pedido();
        pedido.setBilhetes(list);
        pedido.setPessoa(pessoa);
        pedido.setData(new Date());

        return pedido;
    }
}
