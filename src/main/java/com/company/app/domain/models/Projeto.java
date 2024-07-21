package com.company.app.domain.models;

import com.company.app.domain.models.enums.Risco;
import com.company.app.domain.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_projeto")
public class Projeto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long id;

    @NotBlank(message = "O nome do projeto nao deve ser vazio")
    @Size(max = 200, message = "O tamanho do nome do projeto nao deve ultrapassar 200 caracteres")
    @Column(name = "tx_nome")
    private String nome;

    @Column(name = "dt_data_inicio")
    private LocalDate dataInicio;

    @Column(name = "dt_previsao_fim")
    private LocalDate previsaoFim;

    @Column(name = "dt_data_fim")
    private LocalDate dataFim;

    @Size(max = 5000, message = "O tamanho da descricao do projeto nao deve ultrapassar 5000 caracteres")
    @Column(name = "tx_descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tx_status")
    private Status status;

    @Column(name = "num_orcamento")
    private Float orcamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tx_risco")
    private Risco risco;

    @NotNull(message = "O projeto deve ter um gerente")
    @ManyToOne
    @JoinColumn(name = "cd_gerente")
    private Pessoa gerente;
}
