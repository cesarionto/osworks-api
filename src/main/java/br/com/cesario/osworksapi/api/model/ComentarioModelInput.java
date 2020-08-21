package br.com.cesario.osworksapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ComentarioModelInput {
    @NotBlank
    private String descricao;
}
