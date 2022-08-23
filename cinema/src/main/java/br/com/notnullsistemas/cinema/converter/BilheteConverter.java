package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import br.com.notnullsistemas.cinema.repository.PessoaRepository;
import br.com.notnullsistemas.cinema.service.SessaoService;
import liquibase.util.NowAndTodayUtil;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BilheteConverter implements CrudConverter<Bilhete, BilheteDTO> {

    private final PessoaRepository pessoaRepository;
    private final SessaoService sessaoService;
    private final PessoaConverter pessoaConverter;
    private final SessaoMinConverter sessaoMinConverter;

    @Override
    public BilheteDTO entidadeParaDto(Bilhete entidade) {

        BilheteDTO bilhete = new BilheteDTO();
        bilhete.setId(entidade.getId());
        bilhete.setPoltrona(entidade.getPoltrona());
        bilhete.setMeia(entidade.getMeia());
        bilhete.setTotal(entidade.getTotal());
        bilhete.setDataCompra(entidade.getDataCompra());
        bilhete.setDiaSessao(entidade.getDiaSessao());
        bilhete.setPessoa(pessoaConverter.entidadeParaDto(entidade.getPessoa()));
        bilhete.setPessoaId(entidade.getPessoa().getId());
        bilhete.setSessaoId(entidade.getSessao().getId());
        bilhete.setSessao(sessaoMinConverter.entidadeParaDto(entidade.getSessao()));

        return bilhete;
    }

    @Override
    public Bilhete dtoParaEntidade(BilheteDTO dto) {
        Pessoa pessoa = null;
        if (dto.getPessoaId() != null) {
            pessoa = pessoaRepository.findById(dto.getPessoaId()).orElse(null);
        } else if (dto.getPessoa().getCpf() != null && dto.getPessoa().getNome() != null) {
            pessoa = pessoaRepository.save(pessoaConverter.dtoParaEntidade(dto.getPessoa()));
        } else {
            throw new RuntimeException("Precisa ter NOME e CPF!!!!!!!!!!!!!!");
        }

        Sessao sessao = sessaoService.porId(dto.getSessaoId());

        Date agora = new Date();
        dto.setDataCompra(agora);

        Bilhete bilhete = new Bilhete();
        bilhete.setPessoa(pessoa);
        bilhete.setPoltrona(dto.getPoltrona());
        bilhete.setMeia(dto.getMeia());
        bilhete.setTotal(dto.getTotal());
        bilhete.setDataCompra(dto.getDataCompra());
        bilhete.setDiaSessao(dto.getDiaSessao());
        bilhete.setSessao(sessao);

        return bilhete;
    }
}
