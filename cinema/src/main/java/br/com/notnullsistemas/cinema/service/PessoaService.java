package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.core.exception.CinemaException;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService extends CrudService<Pessoa, Long> {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    protected void validar(Pessoa entidade) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(entidade.getCpf());
        if(pessoa.isPresent() && !pessoa.get().getId().equals(entidade.getId())){
            throw new CinemaException("Já existe uma Pessoa cadastrada com esse CPF!");
        }
    }

    @Override
    protected void editarEntidade(Pessoa entidade, Pessoa recuperado) {
        recuperado.setNome(entidade.getNome());
        recuperado.setCpf(entidade.getCpf());
    }

    public Pessoa findByCpf(String cpf){
        return pessoaRepository.findByCpf(cpf).orElse(null);
    }
}
