package com.company.app.mappers;

import com.company.app.dto.ProjetoMembroDTO;
import com.company.app.model.ProjetoMembro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetoMembroMapper {
    ProjetoMembroDTO toDto(ProjetoMembro projetoMembro);
    ProjetoMembro toEntity(ProjetoMembroDTO projetoMembroDTO);
}
