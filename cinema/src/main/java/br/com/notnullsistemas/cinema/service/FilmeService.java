package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.core.exception.CinemaException;
import br.com.notnullsistemas.cinema.domain.Filme;
import br.com.notnullsistemas.cinema.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmeService extends CrudService<Filme, Long> {

    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    protected void validar(Filme entidade) {
        Optional<Filme> filme = filmeRepository.findByNome(entidade.getNome());

        if(filme.isPresent() && !filme.get().getId().equals(entidade.getId())){
            throw new CinemaException("Já existe um Filme cadastrado com esse nome!");
        }

    }

    @Override
    protected void editarEntidade(Filme entidade, Filme recuperado) {

        recuperado.setNome(entidade.getNome());
        recuperado.setDuracao(entidade.getDuracao());
        recuperado.setGeneros(entidade.getGeneros());
        recuperado.setDiretor(entidade.getDiretor());
        recuperado.setSinopse(entidade.getSinopse());
        recuperado.setAtores(entidade.getAtores());
        recuperado.setBannerUrl(entidade.getBannerUrl());
        recuperado.setPosterUrl(entidade.getPosterUrl());
    }

}
