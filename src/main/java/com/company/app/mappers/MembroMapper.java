package com.company.app.mappers;

import com.company.app.dto.MembroDTO;
import com.company.app.model.Membro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MembroMapper {
    MembroDTO toDto(Membro membro);
    Membro toEntity(MembroDTO membroDTO);
}
