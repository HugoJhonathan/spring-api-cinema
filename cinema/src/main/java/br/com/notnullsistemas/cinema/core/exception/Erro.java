package br.com.notnullsistemas.cinema.core.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Erro {

    private Integer status;
    private LocalDate data = LocalDate.now();
    private String descricao;

    public static class Campo {

        private final String nome;
        private final String mensagem;

        public Campo(String nome, String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }
    }
}
