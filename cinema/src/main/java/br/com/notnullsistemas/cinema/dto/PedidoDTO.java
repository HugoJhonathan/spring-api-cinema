package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO implements Serializable {
    private Long id;
    private Long pessoaId;
    private PessoaDTO pessoa;
    private Double total;
    private List<BilheteDTO> bilhetes;
}
