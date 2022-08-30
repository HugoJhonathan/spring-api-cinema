package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Filme;
import br.com.notnullsistemas.cinema.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService extends CrudService<Filme, Long> {

    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    protected void validar(Filme entidade) {
        boolean filmeExiste = filmeRepository.existsByNome(entidade.getNome());
        if(filmeExiste){
            throw new RuntimeException("Filme já cadastrado.");
        }
    }

    @Override
    protected void editarEntidade(Filme entidade, Filme recuperado) {
        recuperado.setId(entidade.getId());
        recuperado.setNome(entidade.getNome());
        recuperado.setDuracao(entidade.getDuracao());
        recuperado.setGeneros(entidade.getGeneros());
        recuperado.setDiretor(entidade.getDiretor());
        recuperado.setSinopse(entidade.getSinopse());
        recuperado.setAtores(entidade.getAtores());
    }

}
