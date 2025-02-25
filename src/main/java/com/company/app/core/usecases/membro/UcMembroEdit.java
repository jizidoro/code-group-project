package com.company.app.core.usecases.membro;

import com.company.app.core.bases.UseCase;
import com.company.app.domain.models.Membro;
import com.company.app.persistence.repositories.MembroRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UcMembroEdit extends UseCase<Membro> {
    @Autowired
    private MembroRepository _repository;
    private Membro entity;

    public UcMembroEdit(Membro entity) {
        super();
        this.entity = entity;
    }

    @Override
    protected Membro execute() throws Exception {
        var result = _repository.findById(entity.getId());
        if (result.isPresent()) {
            return _repository.save(entity);
        }
        return null;
    }
}
