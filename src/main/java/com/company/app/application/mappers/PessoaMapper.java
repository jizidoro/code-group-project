package com.company.app.application.mappers;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.domain.models.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO toDto(Pessoa entity);
    Pessoa toEntity(PessoaDTO dto);
}
