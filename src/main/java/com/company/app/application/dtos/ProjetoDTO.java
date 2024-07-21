package com.company.app.application.dtos;

import com.company.app.domain.models.Pessoa;
import com.company.app.domain.models.enums.Risco;
import com.company.app.domain.models.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate previsaoFim;
    private LocalDate dataFim;
    private String descricao;
    private Status status;
    private Float orcamento;
    private Risco risco;
    private Pessoa gerente;
}