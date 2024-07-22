package com.company.app.application.services.pessoa;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.mappers.PessoaMapper;
import com.company.app.core.bases.UseCaseFacade;
import com.company.app.core.usecases.pessoa.UcPessoaCreate;
import com.company.app.core.usecases.pessoa.UcPessoaDelete;
import com.company.app.core.usecases.pessoa.UcPessoaEdit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaCommand implements IPessoaCommand {
    private final PessoaMapper mapper;
    private final UseCaseFacade facade;

    @Override
    public PessoaDTO save(PessoaDTO dto) {
        var result = mapper.toEntity(dto);
        return mapper.toDto(facade.execute(new UcPessoaCreate(result)));
    }

    @Override
    public PessoaDTO update(PessoaDTO dto) {
        var result = mapper.toEntity(dto);
        return mapper.toDto(facade.execute(new UcPessoaEdit(result)));
    }

    @Override
    public Void delete(Long id) {
        return facade.execute(new UcPessoaDelete(id));
    }
}
