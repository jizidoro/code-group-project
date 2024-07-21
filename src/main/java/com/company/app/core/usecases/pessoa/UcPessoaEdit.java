package com.company.app.core.usecases.pessoa;

import com.company.app.core.bases.UseCase;
import com.company.app.domain.models.Pessoa;
import com.company.app.persistence.repositories.PessoaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UcPessoaEdit extends UseCase<Pessoa> {
    @Autowired
    private PessoaRepository _repository;
    private Pessoa entity;

    public UcPessoaEdit(Pessoa pessoa) {
        super();
        this.entity = pessoa;
    }

    @Override
    protected Pessoa execute() throws Exception {
        var result = _repository.findById(entity.getId());
        if (result.isPresent()) {
            return _repository.save(entity);
        }
        return null;
    }
}
