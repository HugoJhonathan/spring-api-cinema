package br.com.notnullsistemas.cinema.converter;

import org.springframework.stereotype.Component;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Sala;
import br.com.notnullsistemas.cinema.dto.SalaDTO;

@Component
public class SalaConverter implements CrudConverter<Sala, SalaDTO> {

    @Override
    public SalaDTO entidadeParaDto(Sala entidade) {
        return new SalaDTO(entidade.getId(), entidade.getNome(), entidade.getCapacidade());
    }

    @Override
    public Sala dtoParaEntidade(SalaDTO dto) {
        return new Sala(dto.getId(), dto.getNome(), dto.getCapacidade());
    }

}
