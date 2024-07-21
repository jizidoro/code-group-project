package com.company.app.application.mappers;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.domain.models.Membro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MembroMapper {
    MembroMapper INSTANCE = Mappers.getMapper(MembroMapper.class);

    MembroDTO toDto(Membro entity);
    Membro toEntity(MembroDTO dto);
}
