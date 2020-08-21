package br.com.cesario.osworksapi.api.model;

import br.com.cesario.osworksapi.domain.model.StatusOrdemServico;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class OrdemServicoModel {
    private Long id;
    private String nomeCliente;
    private String descricao;
    private BigDecimal preco;
    private StatusOrdemServico statusOrdemServico;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalizacao;
}
