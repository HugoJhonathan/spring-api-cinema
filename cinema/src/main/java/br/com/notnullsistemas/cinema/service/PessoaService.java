package br.com.notnullsistemas.cinema.service;

import br.com.notnullsistemas.cinema.core.crud.CrudService;
import br.com.notnullsistemas.cinema.domain.Pessoa;
import br.com.notnullsistemas.cinema.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PessoaService extends CrudService<Pessoa, Long> {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    protected Pessoa editarEntidade(Pessoa recuperado, Pessoa entidade) {
        return null;
    }

    @Override
    public Pessoa criar(Pessoa pessoa){

        Pessoa pessoaR = findByCpf(pessoa.getCpf());

        if(Objects.isNull(pessoaR)){
            return repository.save(pessoa);
        }
        else if(!pessoa.getNome().equals(pessoaR.getNome())){
            throw new RuntimeException("Nome inválido!");
        }

        return pessoaR;
    }

    public Pessoa findByCpf(String cpf){
        return pessoaRepository.findByCpf(cpf).orElse(null);
    }
}
