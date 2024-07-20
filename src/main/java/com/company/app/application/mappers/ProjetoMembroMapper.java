package com.company.app.application.mappers;

import com.company.app.application.dtos.ProjetoMembroDTO;
import com.company.app.domain.models.ProjetoMembro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetoMembroMapper {
    ProjetoMembroDTO toDto(ProjetoMembro projetoMembro);
    ProjetoMembro toEntity(ProjetoMembroDTO projetoMembroDTO);
}
