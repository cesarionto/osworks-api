package br.com.cesario.osworksapi.domain.model;

import br.com.cesario.osworksapi.domain.exception.NegocioException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private OffsetDateTime dataAbertuta;

    @Column(name = "data_finalizacao")
    private OffsetDateTime dataFinalizacao;

    @OneToMany(mappedBy = "ordemServico")
    private List<Comentario> comentarios = new ArrayList<>();

    public boolean podeSerFinalizada() {
        return StatusOrdemServico.ABERTA.equals(getStatusOrdemServico());
    }

    public boolean naoPodeSerFinalizada() {
        return !podeSerFinalizada();
    }

    public void finalizar() {
        if (naoPodeSerFinalizada())
            throw new NegocioException("A Ordem de serviço ja está finalizada");

        setStatusOrdemServico(StatusOrdemServico.FINALIZADA);
        setDataFinalizacao(OffsetDateTime.now());

    }
}
