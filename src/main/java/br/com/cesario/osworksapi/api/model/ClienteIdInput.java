package br.com.cesario.osworksapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteIdInput {
    @NotNull
    private Long id;
}
