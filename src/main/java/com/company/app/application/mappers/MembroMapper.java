package com.company.app.application.mappers;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.domain.models.Membro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MembroMapper {
    MembroDTO toDto(Membro membro);
    Membro toEntity(MembroDTO membroDTO);
}
