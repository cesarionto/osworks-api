package br.com.cesario.osworksapi.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problema {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Campo{
        private String nome;
        private String mensagem;
    }

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;



}
