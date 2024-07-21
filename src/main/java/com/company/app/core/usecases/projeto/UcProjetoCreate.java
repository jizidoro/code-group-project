package com.company.app.core.usecases.projeto;

import com.company.app.core.bases.UseCase;
import com.company.app.domain.models.Projeto;
import com.company.app.persistence.repositories.ProjetoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UcProjetoCreate extends UseCase<Projeto> {
    @Autowired
    private ProjetoRepository _repository;
    private Projeto entity;

    public UcProjetoCreate(Projeto entity) {
        super();
        this.entity = entity;
    }
    
    @Override
    protected Projeto execute() throws Exception {
        return _repository.save(entity);
    }
}
