package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Filme;
import br.com.notnullsistemas.cinema.dto.FilmeDTO;
import org.springframework.stereotype.Component;

@Component
public class FilmeConverter implements CrudConverter<Filme, FilmeDTO> {

    @Override
    public FilmeDTO entidadeParaDto(Filme entidade) {
        FilmeDTO filme = new FilmeDTO();
        filme.setId(entidade.getId());
        filme.setNome(entidade.getNome());
        filme.setDuracao(entidade.getDuracao());
        filme.setGeneros(entidade.getGeneros());
        filme.setDiretor(entidade.getDiretor());
        filme.setSinopse(entidade.getSinopse());
        filme.setAtores(entidade.getAtores());

        return filme;
    }

    @Override
    public Filme dtoParaEntidade(FilmeDTO dto) {
        Filme filme = new Filme();
        filme.setNome(dto.getNome());
        filme.setDuracao(dto.getDuracao());
        filme.setGeneros(dto.getGeneros());
        filme.setDiretor(dto.getDiretor());
        filme.setSinopse(dto.getSinopse());
        filme.setAtores(dto.getAtores());

        return filme;
    }
}
