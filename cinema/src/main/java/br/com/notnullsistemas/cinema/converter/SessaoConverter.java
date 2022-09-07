package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.SessaoDTO;
import br.com.notnullsistemas.cinema.service.FilmeService;
import br.com.notnullsistemas.cinema.service.SalaService;
import br.com.notnullsistemas.cinema.service.TipoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SessaoConverter implements CrudConverter<Sessao, SessaoDTO> {

    private final FilmeConverter filmeConverter;
    private final SalaConverter salaConverter;
    private final TipoConverter tipoConverter;
    private final BilheteMinConverter bilheteMinConverter;

    private final FilmeService filmeService;
    private final SalaService salaService;
    private final TipoService tipoService;

    @Override
    public SessaoDTO entidadeParaDto(Sessao entidade) {
        var dto = new SessaoDTO();
        dto.setId(entidade.getId());
        dto.setHorario(entidade.getHorario());
        dto.setDataInicio(entidade.getDataInicio());
        dto.setDataFinal(entidade.getDataFinal());
        dto.setTotal(entidade.getTotal());
        dto.setAtivo(entidade.getAtivo());
        dto.setFilme(filmeConverter.entidadeParaDto(entidade.getFilme()));
        dto.setSala(salaConverter.entidadeParaDto(entidade.getSala()));
        dto.setTipo(tipoConverter.entidadeParaDto(entidade.getTipo()));
        dto.setBilhetes(entidade.getBilhetes()
                .stream().map(bilheteMinConverter::entidadeParaDto)
                .collect(Collectors.toList()));
        dto.setOcupadas(entidade.getOcupadas());
        dto.setFilmeId(entidade.getFilme().getId());
        dto.setSalaId(entidade.getSala().getId());
        dto.setTipoId(entidade.getTipo().getId());

        return dto;
    }

    @Override
    public Sessao dtoParaEntidade(SessaoDTO dto) throws Exception {
        var sessao = new Sessao();
        sessao.setId(dto.getId());
        sessao.setHorario(dto.getHorario());
        sessao.setDataInicio(dto.getDataInicio());
        sessao.setDataFinal(dto.getDataFinal());

        sessao.setFilme(filmeService.porId(dto.getFilmeId()));
        sessao.setSala(salaService.porId(dto.getSalaId()));
        sessao.setTipo(tipoService.porId(dto.getTipoId()));
        return sessao;
    }
}
