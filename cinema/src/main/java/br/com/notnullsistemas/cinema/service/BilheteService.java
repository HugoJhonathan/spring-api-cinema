package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.core.exception.CinemaException;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.repository.BilheteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BilheteService extends CrudService<Bilhete, Long> {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private BilheteRepository bilheteRepository;

    @Override
    protected void validar(Bilhete entidade) throws Exception {
        Sessao sessao = sessaoService.porId(entidade.getSessao().getId());

        if (entidade.getPoltrona() <= 0 || entidade.getPoltrona() > sessao.getSala().getCapacidade()) {
            throw new CinemaException("Cadeira invalida");
        }

        for (Bilhete bilhete : sessao.getBilhetes()) {
            if (bilhete.getPoltrona() == entidade.getPoltrona()
                    && bilhete.getDiaSessao().equals(entidade.getDiaSessao())) {
                throw new CinemaException("A Poltrona " + entidade.getPoltrona()
                        + " não está disponível para essa Sessão do dia "
                        + entidade.getDiaSessao());
            }
        }

        if (entidade.getMeia()) {
            entidade.setTotal(sessao.getTipo().getPreco() / 2);
        } else {
            entidade.setTotal(sessao.getTipo().getPreco());
        }
    }

    @Override
    protected void editarEntidade(Bilhete entidade, Bilhete recuperado) {
        recuperado.setId(entidade.getId());
        recuperado.setDataCompra(entidade.getDataCompra());
        recuperado.setDiaSessao(entidade.getDiaSessao());
        recuperado.setPoltrona(entidade.getPoltrona());
        recuperado.setTotal(entidade.getTotal());
    }

    public List<Bilhete> findByInterval(String de, String ate) {
        return bilheteRepository.procurarBilhetePorIntervalo(LocalDate.parse(de), LocalDate.parse(ate));
    }

    public List<Bilhete> buscarBilhetesEmSessoes(List<Sessao> sessoes, String de, String ate) {
        List<Bilhete> listaBilhetes = new ArrayList<>();

        final String ate_;
        if (Objects.isNull(ate)) {
            ate_ = de;
        } else {
            ate_ = ate;
        }

        sessoes.stream().forEach(sessao -> {
            sessao.getBilhetes().stream().forEach(bilhete -> {
                if (Objects.isNull(de)) {
                    listaBilhetes.add(bilhete);
                } else {
                    if ((bilhete.getDiaSessao().isEqual(LocalDate.parse(de))
                            || bilhete.getDiaSessao().isAfter(LocalDate.parse(de)))
                            && (bilhete.getDiaSessao().isEqual(LocalDate.parse(ate_))
                                    || bilhete.getDiaSessao().isBefore(LocalDate.parse(ate_)))) {
                        listaBilhetes.add(bilhete);
                    }
                }
            });
        });
        return listaBilhetes;
    }

    public List<Bilhete> bilhetesPorTipo(Long id, String de, String ate) {
        final String ate_;
        if (!Objects.isNull(de)) {
            if (Objects.isNull(ate)) {
                ate_ = de;
            } else {
                ate_ = ate;
            }
            return bilheteRepository.buscarPorTipoData(id, LocalDate.parse(de), LocalDate.parse(ate_));
        } else {
            return bilheteRepository.buscarPorTipo(id);
        }
    }

    public List<Bilhete> bilhetesPorSessao(Sessao sessao, String de, String ate) {
        List<Bilhete> listaBilhetes = new ArrayList<>();
        final String ate_;
        if (Objects.isNull(ate)) {
            ate_ = de;
        } else {
            ate_ = ate;
        }
        sessao.getBilhetes().stream().forEach(bilhete -> {
            if (Objects.isNull(de)) {
                listaBilhetes.add(bilhete);
            } else {
                if ((bilhete.getDiaSessao().isEqual(LocalDate.parse(de))
                        || bilhete.getDiaSessao().isAfter(LocalDate.parse(de)))
                        && (bilhete.getDiaSessao().isEqual(LocalDate.parse(ate_))
                                || bilhete.getDiaSessao().isBefore(LocalDate.parse(ate_)))) {
                    listaBilhetes.add(bilhete);
                }
            }
        });

        return listaBilhetes;
    }

}