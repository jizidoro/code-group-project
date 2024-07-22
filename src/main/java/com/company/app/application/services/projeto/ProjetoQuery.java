package com.company.app.application.services.projeto;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.application.mappers.ProjetoMapper;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;
import com.company.app.persistence.repositories.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetoQuery implements IProjetoQuery {
    private final ProjetoMapper mapper;
    private final ProjetoRepository _repository;

    @Override
    public ListResultDto<ProjetoDTO> findAll() {
        var result = _repository.findAll();
        var response = result.stream().map(mapper::toDto).collect(Collectors.toList());
        return new ListResultDto<>(response);
    }

    @Override
    public SingleResultDto<ProjetoDTO> findById(Long id) {
        var result = _repository.findById(id);
        if (result.isPresent()) {
            var response = mapper.toDto(result.get());
            return new SingleResultDto<>(response);
        }
        return new SingleResultDto<>(0);
    }

    @Override
    public ListResultDto<ProjetoDTO> findByName(String nome) {
        var result = _repository.findByNomeContainingIgnoreCase(nome.trim());
        var response = result.stream().map(mapper::toDto).collect(Collectors.toList());
        return new ListResultDto<>(response);
    }
}
