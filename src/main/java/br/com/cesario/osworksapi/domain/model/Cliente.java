package br.com.cesario.osworksapi.domain.model;

import br.com.cesario.osworksapi.domain.validations.ValidationGroup;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @NotNull(groups = ValidationGroup.ClienteId.class)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    @NotBlank
    @Size(max = 255)
    private String nome;

    @Column(name = "email")
    @NotBlank
    @Email

    @Size(max = 255)
    private String email;

    @Column(name = "telefone")
    @NotBlank
    @Size(max = 20)
    private String telefone;
}