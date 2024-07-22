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
public class ProjetoDTO {
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate previsaoFim;
    private LocalDate dataFim;
    private String descricao;
    private String status;
    private Float orcamento;
    private String risco;
    private Long gerente;
}