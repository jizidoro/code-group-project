package com.company.app.application.dtos;

public class ProjetoMembroDTO {
    private Long id;
    private Long projetoId;
    private Long membroId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        this.projetoId = projetoId;
    }

    public Long getMembroId() {
        return membroId;
    }

    public void setMembroId(Long membroId) {
        this.membroId = membroId;
    }
}