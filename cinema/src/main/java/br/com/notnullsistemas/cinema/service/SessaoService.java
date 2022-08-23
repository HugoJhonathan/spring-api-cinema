package br.com.notnullsistemas.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.repository.SessaoRepository;

@Service
public class SessaoService extends CrudService<Sessao, Long> {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Override
    protected Sessao editarEntidade(Sessao recuperado, Sessao entidade) {
        return null;
    }

    @Override
    public Sessao criar(Sessao entidade) {

        Sessao sessaoAntiga = sessaoRepository.sessaoAtiva(entidade.getHorario(), entidade.getSala().getId());

        if (sessaoAntiga != null) {
            sessaoAntiga.setAtivo(false);
            repository.save(sessaoAntiga);
        }

        Sessao saved = repository.save(entidade);

        return repository.findById(saved.getId()).orElse(null);
    }

}
