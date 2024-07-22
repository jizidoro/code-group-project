package com.company.app.application.services.membro;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.mappers.MembroMapper;
import com.company.app.core.bases.UseCaseFacade;
import com.company.app.core.usecases.membro.UcMembroCreate;
import com.company.app.core.usecases.membro.UcMembroDelete;
import com.company.app.core.usecases.membro.UcMembroEdit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembroCommand implements IMembroCommand {
    private final MembroMapper mapper;
    private final UseCaseFacade facade;

    @Override
    public MembroDTO save(MembroDTO dto) {
        var result = mapper.toEntity(dto);
        return mapper.toDto(facade.execute(new UcMembroCreate(result)));
    }

    @Override
    public MembroDTO update(MembroDTO dto) {
        var result = mapper.toEntity(dto);
        return mapper.toDto(facade.execute(new UcMembroEdit(result)));
    }

    @Override
    public Void delete(Long id) {
        return facade.execute(new UcMembroDelete(id));
    }
}
