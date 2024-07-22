package com.company.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long id;

    @NotBlank(message = "O nome da pessoa nao deve ser vazio")
    @Size(max = 100, message = "O tamanho do nome da pessoa nao deve ultrapassar 100 caracteres")
    @Column(name = "tx_nome")
    private String nome;

    @NotNull(message = "A data de nascimento da pessoa nao deve ser nula")
    @Column(name = "dt_data_nascimento")
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF da pessoa nao deve ser vazio")
    @Size(max = 14, message = "O tamanho do CPF da pessoa nao deve ultrapassar 14 caracteres")
    @Column(name = "tx_cpf")
    private String cpf;

    @Column(name = "is_funcionario")
    private Boolean funcionario;

    @Column(name = "is_gerente")
    private Boolean gerente;
}