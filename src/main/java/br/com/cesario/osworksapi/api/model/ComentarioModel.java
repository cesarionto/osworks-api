package br.com.cesario.osworksapi.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ComentarioModel {
    private Long id;
    private String descricao;
    private OffsetDateTime dataEnvio;
}
