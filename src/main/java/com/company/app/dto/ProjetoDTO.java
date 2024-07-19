package com.company.app.dto;

public class ProjetoDTO {
    private Long id;
    private String nome;
    private String dataInicio;
    private String gerenteResponsavel;
    private String previsaoTermino;
    private String dataRealTermino;
    private Double orcamentoTotal;
    private String descricao;
    private String status;
    private String risco;

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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(String gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }

    public String getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(String previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }

    public String getDataRealTermino() {
        return dataRealTermino;
    }

    public void setDataRealTermino(String dataRealTermino) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }
}