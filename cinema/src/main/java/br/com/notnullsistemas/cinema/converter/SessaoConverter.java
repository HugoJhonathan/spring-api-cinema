package br.com.notnullsistemas.cinema.converter;

import org.springframework.stereotype.Component;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.SessaoDTO;
import br.com.notnullsistemas.cinema.repository.FilmeRepository;
import br.com.notnullsistemas.cinema.repository.SalaRepository;
import br.com.notnullsistemas.cinema.repository.TipoRepository;
import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SessaoConverter implements CrudConverter<Sessao, SessaoDTO> {

    private final FilmeConverter filmeConverter;
    private final SalaConverter salaConverter;
    private final TipoConverter tipoConverter;
    private final BilheteMinConverter bilheteMinConverter;

    private final FilmeRepository filmeRepository;
    private final SalaRepository salaRepository;
    private final TipoRepository tipoRepository;

    @Override
    public SessaoDTO entidadeParaDto(Sessao entidade) {
        var dto = new SessaoDTO();
        dto.setId(entidade.getId());
        dto.setHorario(entidade.getHorario());
        dto.setTotal(entidade.getTotal());
        dto.setFilme(filmeConverter.entidadeParaDto(entidade.getFilme()));
        dto.setSala(salaConverter.entidadeParaDto(entidade.getSala()));
        dto.setTipo(tipoConverter.entidadeParaDto(entidade.getTipo()));
        dto.setBilhetes(entidade.getBilhetes()
                .stream().map(bilheteMinConverter::entidadeParaDto)
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Sessao dtoParaEntidade(SessaoDTO dto) {
        var sessao = new Sessao();
        sessao.setId(dto.getId());
        sessao.setHorario(dto.getHorario());
        sessao.setFilme(filmeRepository.findById(dto.getFilmeId()).orElse(null));
        sessao.setSala(salaRepository.findById(dto.getSalaId()).orElse(null));
        sessao.setTipo(tipoRepository.findById(dto.getTipoId()).orElse(null));
        return sessao;
    }
}
