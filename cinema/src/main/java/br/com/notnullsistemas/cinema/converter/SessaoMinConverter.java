package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.SessaoMinDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SessaoMinConverter implements CrudConverter<Sessao, SessaoMinDTO> {

    private final SalaConverter salaConverter;
    private final FilmeConverter filmeConverter;
    private final TipoConverter tipoConverter;

    @Override
    public SessaoMinDTO entidadeParaDto(Sessao entidade) {
        SessaoMinDTO sessaoMinDTO = new SessaoMinDTO();
        sessaoMinDTO.setId(entidade.getId());
        sessaoMinDTO.setHorario(entidade.getHorario());
        sessaoMinDTO.setSala(salaConverter.entidadeParaDto(entidade.getSala()));
        sessaoMinDTO.setFilme(filmeConverter.entidadeParaDto(entidade.getFilme()));
        sessaoMinDTO.setTipo(tipoConverter.entidadeParaDto(entidade.getTipo()));
        return sessaoMinDTO;
    }

    @Override
    public Sessao dtoParaEntidade(SessaoMinDTO dto) {
        return null;
    }

}
