package br.com.notnullsistemas.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaDTO implements Serializable {
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    @CPF(message="CPF Inválido!")
    private String cpf;
}
