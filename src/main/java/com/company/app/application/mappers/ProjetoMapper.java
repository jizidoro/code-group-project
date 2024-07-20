package com.company.app.application.mappers;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.domain.models.Projeto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {
    ProjetoDTO toDto(Projeto projeto);
    Projeto toEntity(ProjetoDTO projetoDTO);
}
