package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.domain.Sessao;
import br.com.notnullsistemas.cinema.dto.BilheteDTO;
import br.com.notnullsistemas.cinema.service.PessoaService;
import br.com.notnullsistemas.cinema.service.SessaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BilheteConverter implements CrudConverter<Bilhete, BilheteDTO> {

    private final PessoaService pessoaService;
    private final SessaoService sessaoService;
    private final PessoaConverter pessoaConverter;

    @Override
    public BilheteDTO entidadeParaDto(Bilhete entidade) {

        BilheteDTO bilhete = new BilheteDTO();
        bilhete.setId(entidade.getId());
        bilhete.setPoltrona(entidade.getPoltrona());
        bilhete.setMeia(entidade.getMeia());
        bilhete.setTotal(entidade.getTotal());
        bilhete.setPessoa(pessoaConverter.entidadeParaDto(entidade.getPessoa()));
        bilhete.setPessoaId(entidade.getPessoa().getId());
        bilhete.setSessaoId(entidade.getSessao().getId());

        return bilhete;
    }

    @Override
    public Bilhete dtoParaEntidade(BilheteDTO dto) {
        Pessoa pessoa = pessoaService.porId(dto.getPessoaId());
        Sessao sessao = sessaoService.porId(dto.getSessaoId());

        Bilhete bilhete = new Bilhete();
        bilhete.setPessoa(pessoa);
        bilhete.setPoltrona(dto.getPoltrona());
        bilhete.setMeia(dto.getMeia());
        bilhete.setTotal(dto.getTotal());
        bilhete.setSessao(sessao);

        return bilhete;
    }
}
