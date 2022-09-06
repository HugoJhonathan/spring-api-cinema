package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class SessaoService extends CrudService<Sessao, Long> {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Override
    public void validar(Sessao entidade) {

        if (entidade.getSala() != null) {
            Sessao sessaoAntiga = sessaoRepository.sessaoAtiva(entidade.getHorario(), entidade.getSala().getId());

            if (sessaoAntiga != null) {
                sessaoAntiga.setAtivo(false);
                repository.save(sessaoAntiga);
            }
        }
        LocalDate dataFinal = entidade.getDataFinal();
//        entidade.setAtivo(true);

        if (Objects.isNull(dataFinal) && entidade.getDataInicio() != null) {
            LocalDate dataInicio = entidade.getDataInicio();
            entidade.setDataFinal(dataInicio.plusDays(7));
        }
    }

    @Override
    protected void editarEntidade(Sessao entidade, Sessao recuperado) {
        recuperado.setAtivo(entidade.getAtivo());
    }

    public List<Sessao> findByInterval(String de, String ate) {
        List<Sessao> sessoes = sessaoRepository.procurarSessaoPorIntervalo(LocalDate.parse(de), LocalDate.parse(ate));
        filtrarBilhetes(sessoes, LocalDate.parse(de), LocalDate.parse(ate));
        return sessoes;
    }


    private void filtrarBilhetes(List<Sessao> sessoes, LocalDate de_, LocalDate ate_) {
        sessoes.stream().forEach(sessao_ -> {

            Iterator<Bilhete> iter = sessao_.getBilhetes().iterator();
            while (iter.hasNext()) {
                Bilhete bilhete = iter.next();
                if (!(bilhete.getDiaSessao().isAfter(de_.minusDays(1)) && bilhete.getDiaSessao().isBefore(ate_.plusDays(1)))) {
                    iter.remove();
                }
            }
        });
    }

    public List<Sessao> listarTodos(String horario, String de, String ate) {
        if (!Objects.isNull(de)) {

            if (Objects.isNull(ate)) {
                ate = de;
            }

            LocalDate de_ = LocalDate.parse(de);
            LocalDate ate_ = LocalDate.parse(ate);

            if (!Objects.isNull(horario)) {
                List<Sessao> sessoes = sessaoRepository.listarSessoesDeUmHorarioEmUmPeriodo(LocalTime.parse(horario), de_, ate_);
                filtrarBilhetes(sessoes, de_, ate_);
                return sessoes;
            }

            return findByInterval(de, ate);
        }

        return listar();
    }

    public List<Sessao> listarSessoesDeUmaSala(Long id, String de, String ate) {
        if (Objects.isNull(ate)) {
            ate = de;
        }

        if (Objects.isNull(de)) {
            List<Sessao> sessoes = sessaoRepository.listarSessoesDeUmaSala(id);
            return sessoes;
        }

        List<Sessao> sessoes = sessaoRepository.listarSessoesDeUmaSalaEmUmPeriodo(id, LocalDate.parse(de), LocalDate.parse(ate));
        return sessoes;
    }

}
