package br.com.notnullsistemas.cinema.converter;

import org.springframework.stereotype.Component;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Tipo;
import br.com.notnullsistemas.cinema.dto.TipoDTO;

@Component
public class TipoConverter implements CrudConverter<Tipo, TipoDTO> {

    @Override
    public TipoDTO entidadeParaDto(Tipo entidade) {
        return new TipoDTO(entidade.getId(), entidade.getNome(), entidade.getPreco());
    }

    @Override
    public Tipo dtoParaEntidade(TipoDTO dto) {
        return new Tipo(dto.getId(), dto.getNome(), dto.getPreco());
    }
}
