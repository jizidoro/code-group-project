package com.company.app.domain.models;

import com.company.app.domain.models.enums.Risco;
import com.company.app.domain.models.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projetos")
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Date dataInicio;
    private String gerenteResponsavel;
    private Date previsaoTermino;
    private Date dataRealTermino;
    private Double orcamentoTotal;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Risco risco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(String gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }

    public Date getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(Date previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }

    public Date getDataRealTermino() {
        return dataRealTermino;
    }

    public void setDataRealTermino(Date dataRealTermino) {
        this.dataRealTermino = dataRealTermino;
    }

    public Double getOrcamentoTotal() {
        return orcamentoTotal;
    }

    public void setOrcamentoTotal(Double orcamentoTotal) {
        this.orcamentoTotal = orcamentoTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }
}
