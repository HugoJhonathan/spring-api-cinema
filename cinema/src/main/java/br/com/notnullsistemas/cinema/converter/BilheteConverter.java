package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import br.com.notnullsistemas.cinema.repository.PessoaRepository;
import br.com.notnullsistemas.cinema.service.PessoaService;
import br.com.notnullsistemas.cinema.service.SessaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class BilheteConverter implements CrudConverter<Bilhete, BilheteDTO> {

    private final PessoaRepository pessoaRepository;
    private final SessaoService sessaoService;
    private final PessoaConverter pessoaConverter;
    private final SessaoMinConverter sessaoMinConverter;
    private final PessoaService pessoaService;

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

        Pessoa pessoa = pessoaService.porId(dto.getPessoaId());
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
