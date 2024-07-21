package com.company.app.core.usecases.projeto;

import com.company.app.core.bases.UseCase;
import com.company.app.persistence.repositories.ProjetoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UcProjetoDelete extends UseCase<Void> {
    @Autowired
    private ProjetoRepository _repository;
    private Long id;

    public UcProjetoDelete(Long id) {
        super();
        this.id = id;
    }

    @Override
    protected Void execute() throws Exception {
        _repository.deleteById(id);
        return null;
    }
}
