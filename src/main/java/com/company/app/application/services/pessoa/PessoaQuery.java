package com.company.app.application.services.pessoa;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.mappers.PessoaMapper;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;
import com.company.app.persistence.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaQuery implements IPessoaQuery {
    private final PessoaMapper mapper = PessoaMapper.INSTANCE;
    private final PessoaRepository _repository;

    public ListResultDto<PessoaDTO> findAll() {
        var result = _repository.findAll();
        var response = result.stream().map(mapper::toDto).collect(Collectors.toList());
        return new ListResultDto<>(response);
    }

    public SingleResultDto<PessoaDTO> findById(Long id) {
        var result = _repository.findById(id);
        if (result.isPresent()) {
            var response = mapper.toDto(result.get());
            return new SingleResultDto<>(response);
        }
        return new SingleResultDto<>(0);
    }
}
