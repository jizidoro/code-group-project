package com.company.app.mappers;

import com.company.app.dto.ProjetoDTO;
import com.company.app.model.Projeto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {
    ProjetoDTO toDto(Projeto projeto);
    Projeto toEntity(ProjetoDTO projetoDTO);
}
