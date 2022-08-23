package br.com.notnullsistemas.cinema.converter;

import br.com.notnullsistemas.cinema.core.crud.CrudConverter;
import br.com.notnullsistemas.cinema.domain.Bilhete;
import br.com.notnullsistemas.cinema.dto.BilheteMinDTO;
import br.com.notnullsistemas.cinema.repository.PessoaRepository;
import br.com.notnullsistemas.cinema.service.SessaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BilheteMinConverter implements CrudConverter<Bilhete, BilheteMinDTO> {

    private final PessoaRepository pessoaRepository;
    private final SessaoService sessaoService;
    private final PessoaConverter pessoaConverter;
    private final SessaoMinConverter sessaoMinConverter;

    @Override
    public BilheteMinDTO entidadeParaDto(Bilhete entidade) {

        BilheteMinDTO bilhete = new BilheteMinDTO();
        bilhete.setId(entidade.getId());
        bilhete.setPoltrona(entidade.getPoltrona());
        bilhete.setMeia(entidade.getMeia());
        bilhete.setTotal(entidade.getTotal());
        bilhete.setDataCompra(entidade.getDataCompra());
        bilhete.setDiaSessao(entidade.getDiaSessao());
        bilhete.setPessoa(pessoaConverter.entidadeParaDto(entidade.getPessoa()));
        bilhete.setPessoaId(entidade.getPessoa().getId());
        bilhete.setSessaoId(entidade.getSessao().getId());
        bilhete.setHorarioSessao(entidade.getSessao().getHorario());

        return bilhete;
    }

    @Override
    public Bilhete dtoParaEntidade(BilheteMinDTO dto) {
        return null;
    }
}
