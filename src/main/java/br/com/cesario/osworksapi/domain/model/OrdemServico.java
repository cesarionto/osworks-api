package br.com.cesario.osworksapi.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "ordens_servico")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String descricao;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusOrdemServico statusOrdemServico;

    @Column(name = "data_abertura")
    private LocalDateTime dataAbertuta;

    @Column(name = "data_finalizacao")
    private LocalDateTime dataFinalizacao;

}
