package br.com.cesario.osworksapi.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrdemServico ordemServico;

    private String descricao;

    @Column(name = "data_envio")
    private OffsetDateTime dataEnvio;

}
