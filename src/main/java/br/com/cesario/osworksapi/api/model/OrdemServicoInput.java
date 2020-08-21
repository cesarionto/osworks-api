package br.com.cesario.osworksapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class OrdemServicoInput {
    @Valid
    @NotNull
    private ClienteIdInput id_cliente;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal preco;

}
