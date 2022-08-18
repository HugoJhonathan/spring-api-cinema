package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Sessao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilheteService extends CrudService<Bilhete, Long> {

    @Autowired
    private SessaoService sessaoService;

    protected Bilhete editarEntidade(Bilhete recuperado, Bilhete entidade) {
        return null;
    }

    @Override
    public Bilhete criar(Bilhete entidade) {
        Sessao sessao = sessaoService.porId(entidade.getId());
        List<Integer> cadeirasOcupadas = new ArrayList<>();
        for (Bilhete bilhete : sessao.getBilhetes()) {
            if (bilhete.getPoltrona() == entidade.getPoltrona()) {
                // throw new RuntimeException("asdfklj");
                return null;
            } else {
                cadeirasOcupadas.add(bilhete.getPoltrona());
            }
        }
        System.out.print("\n\n\n\n\n\n-----------------------------salvo mesmo assim-----------------\n\n\n\n\n\n");

        return repository.save(entidade);
    }

}
