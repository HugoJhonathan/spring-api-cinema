package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.domain.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilheteService extends CrudService<Bilhete, Long> {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private SalaService salaService;

    protected Bilhete editarEntidade(Bilhete recuperado, Bilhete entidade) {
        return null;
    }

    @Override
    public Bilhete criar(Bilhete entidade) {
        Sessao sessao = sessaoService.porId(entidade.getSessao().getId());
        Pessoa pessoa = pessoaService.porId(entidade.getPessoa().getId());
        entidade.setPessoa(pessoa);

        if (entidade.getPoltrona() <= 0 || entidade.getPoltrona() > sessao.getSala().getCapacidade()) {
            throw new RuntimeException("Cadeira invalida");
        }

        for (Bilhete bilhete : sessao.getBilhetes()) {
            if (bilhete.getPoltrona() == entidade.getPoltrona() && bilhete.getDiaSessao() == entidade.getDiaSessao()) {
                throw new RuntimeException("Cadeira " + entidade.getPoltrona() + " já está ocupada");
            }
        }

        if (entidade.getMeia()) {
            entidade.setTotal(sessao.getTipo().getPreco() / 2);
        } else {
            entidade.setTotal(sessao.getTipo().getPreco());
        }

        Bilhete saved = repository.save(entidade);

        return repository.findById(saved.getId()).orElse(null);
    }

}
