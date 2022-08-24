package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class SessaoService extends CrudService<Sessao, Long> {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Override
    protected Sessao editarEntidade(Sessao recuperado, Sessao entidade) {
        return null;
    }

    @Override
    public List<Sessao> findByInterval(String de, String ate) {
        return sessaoRepository.procurarSessaoPorIntervalo(LocalDate.parse(de), LocalDate.parse(ate));
    }

    @Override
    public Sessao criar(Sessao entidade) {

        Sessao sessaoAntiga = sessaoRepository.sessaoAtiva(entidade.getHorario(), entidade.getSala().getId());

        if (sessaoAntiga != null) {
            sessaoAntiga.setAtivo(false);
            repository.save(sessaoAntiga);
        }
        var dataFinal = entidade.getDataFinal();

        if(Objects.isNull(dataFinal)){
            var dataInicio = entidade.getDataInicio();
            entidade.setDataFinal(dataInicio.plusDays(7));
        }

        Sessao saved = repository.save(entidade);

        return repository.findById(saved.getId()).orElse(null);
    }

}
