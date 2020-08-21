package br.com.cesario.osworksapi.domain.exception;

import br.com.cesario.osworksapi.domain.exception.NegocioException;

public class EntidadeNãoEncontradaExceptions extends NegocioException {
    public EntidadeNãoEncontradaExceptions(String mensagem){
        super(mensagem);
    }
}
