package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.domain.Sessao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilheteService extends CrudService<Bilhete, Long> {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private PessoaService pessoaService;

    protected Bilhete editarEntidade(Bilhete recuperado, Bilhete entidade) {
        return null;
    }

    @Override
    public Bilhete criar(Bilhete entidade) {
        Sessao sessao = sessaoService.porId(entidade.getSessao().getId());

        for (Bilhete bilhete : sessao.getBilhetes()) {
            if (bilhete.getPoltrona() == entidade.getPoltrona()) {
//                throw new RuntimeException("Cadeira "+entidade.getPoltrona()+" já está ocupada");
                return null;
            }
        }

        Pessoa pessoa = pessoaService.porId(entidade.getPessoa().getId());
        entidade.setSessao(sessao);
        entidade.setPessoa(pessoa);
        Bilhete saved = repository.save(entidade);

        return repository.findById(saved.getId()).orElse(null);
    }

}
