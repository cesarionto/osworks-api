package br.com.cesario.osworksapi.api.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ApiExceptionHendler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    public ApiExceptionHendler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        var problema = new Problema();
        var campos = new ArrayList<Problema.Campo>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Problema.Campo(nome, mensagem));
        }

        problema.setStatus(status.value());
        problema.setTitulo("Um ou mais campos estão invalidos," +
                "faça o preenchimento correto e tente novamente");
        problema.setDataHora(LocalDateTime.now());
        problema.setCampos(campos);
        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }
}