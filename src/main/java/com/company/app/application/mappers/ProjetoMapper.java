package com.company.app.application.mappers;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.domain.models.Projeto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {
    ProjetoMapper INSTANCE = Mappers.getMapper(ProjetoMapper.class);

    ProjetoDTO toDto(Projeto entity);
    Projeto toEntity(ProjetoDTO dto);
}
