package br.com.cesario.osworksapi.domain.model;

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