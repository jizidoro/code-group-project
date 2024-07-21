package com.company.app.application.services.membro;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.mappers.MembroMapper;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;
import com.company.app.persistence.repositories.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembroQuery implements IMembroQuery {
    private final MembroMapper mapper = MembroMapper.INSTANCE;
    private final MembroRepository _repository;

    public ListResultDto<MembroDTO> findAll() {
        var result = _repository.findAll();
        var response = result.stream().map(mapper::toDto).collect(Collectors.toList());
        return new ListResultDto<>(response);
    }

    public SingleResultDto<MembroDTO> findById(Long id) {
        var result = _repository.findById(id);
        if (result.isPresent()) {
            var response = mapper.toDto(result.get());
            return new SingleResultDto<>(response);
        }
        return new SingleResultDto<>(0);
    }
}
