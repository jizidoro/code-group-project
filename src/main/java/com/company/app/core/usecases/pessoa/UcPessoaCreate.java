package com.company.app.core.usecases.pessoa;

import com.company.app.core.bases.UseCase;
import com.company.app.domain.models.Pessoa;
import com.company.app.persistence.repositories.PessoaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UcPessoaCreate extends UseCase<Pessoa> {
    @Autowired
    private PessoaRepository _repository;
    private Pessoa entity;

    public UcPessoaCreate(Pessoa entity) {
        super();
        this.entity = entity;
    }
    
    @Override
    protected Pessoa execute() throws Exception {
        return _repository.save(entity);
    }
}
