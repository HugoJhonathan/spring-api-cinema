package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.repository.BilheteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BilheteService extends CrudService<Bilhete, Long> {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private PessoaService pessoaService;

    // @Autowired
    // private SalaService salaService;

    @Autowired
    private BilheteRepository bilheteRepository;

    protected Bilhete editarEntidade(Bilhete recuperado, Bilhete entidade) {
        return null;
    }

    @Override
    public List<Bilhete> findByInterval(String de, String ate) {
        return bilheteRepository.procurarBilhetePorIntervalo(LocalDate.parse(de), LocalDate.parse(ate));
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
            if (bilhete.getPoltrona() == entidade.getPoltrona()
                    && bilhete.getDiaSessao().equals(entidade.getDiaSessao())) {
                throw new RuntimeException("A Poltrona " + entidade.getPoltrona()
                        + " não está disponível para essa Sessão do dia "
                        + entidade.getDiaSessao());
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