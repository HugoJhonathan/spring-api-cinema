package br.com.notnullsistemas.cinema.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CinemaExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NotNull MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<Erro.Campo> campos = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = ((FieldError) error).getDefaultMessage();
            campos.add(new Erro.Campo(nome, mensagem));
        }

        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setDescricao("Um ou mais campos são inválidos. Por favor preencha novamente.");

        return handleExceptionInternal(ex, erro, headers, status, request);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<Object> entidadeNaoEncontrada(CinemaException ex, WebRequest request) {
        return handleException(ex, new Erro(), HttpStatus.NOT_FOUND, request);
    }

    private ResponseEntity<Object> handleException(Exception ex, Erro erro, HttpStatus status, WebRequest request) {
        erro.setStatus(status.value());
        erro.setDescricao(ex.getMessage());
        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
    }
}