package com.company.app.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Boolean funcionario;
    private Boolean gerente;
}
