package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.dto.PessoaDTO;
import org.springframework.stereotype.Component;

@Component
public class PessoaConverter implements CrudConverter<Pessoa, PessoaDTO> {

    @Override
    public PessoaDTO entidadeParaDto(Pessoa entidade) {
        return new PessoaDTO(entidade.getId(), entidade.getNome(), entidade.getCpf());
    }

    @Override
    public Pessoa dtoParaEntidade(PessoaDTO dto) {
        return new Pessoa(dto.getId(), dto.getNome(), dto.getCpf());
    }
}
