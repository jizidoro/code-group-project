package com.company.app.core.usecases.pessoa;

import com.company.app.core.bases.UseCase;
import com.company.app.persistence.repositories.PessoaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UcPessoaDelete extends UseCase<Void> {
    @Autowired
    private PessoaRepository _repository;
    private Long id;

    public UcPessoaDelete(Long id) {
        super();
        this.id = id;
    }

    @Override
    protected Void execute() throws Exception {
        _repository.deleteById(id);
        return null;
    }
}
