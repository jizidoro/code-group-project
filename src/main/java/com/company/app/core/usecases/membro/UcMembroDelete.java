package com.company.app.core.usecases.membro;

import com.company.app.core.bases.UseCase;
import com.company.app.persistence.repositories.MembroRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UcMembroDelete extends UseCase<Void> {
    @Autowired
    private MembroRepository _repository;
    private Long id;

    public UcMembroDelete(Long id) {
        super();
        this.id = id;
    }

    @Override
    protected Void execute() throws Exception {
        _repository.deleteById(id);
        return null;
    }
}
