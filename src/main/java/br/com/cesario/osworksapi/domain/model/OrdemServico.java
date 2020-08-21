package br.com.cesario.osworksapi.domain.model;

import br.com.cesario.osworksapi.domain.validations.ValidationGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "ordens_servico")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroup.ClienteId.class)
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusOrdemServico statusOrdemServico;

    @Column(name = "data_abertura")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataAbertuta;

    @Column(name = "data_finalizacao")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

}
