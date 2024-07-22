package com.company.app.application.mappers;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.domain.models.Membro;
import com.company.app.domain.models.Pessoa;
import com.company.app.domain.models.Projeto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MembroMapperTest {

    private final MembroMapper membroMapper = MembroMapper.INSTANCE;

    @Test
    public void toDto_deveConverterEntityParaDto() {
        Membro membro = new Membro(1L, 1L, 1L);

        MembroDTO membroDTO = membroMapper.toDto(membro);

        assertEquals(membro.getId(), membroDTO.getId());
        assertEquals(membro.getProjeto(), membroDTO.getProjeto());
        assertEquals(membro.getPessoa(), membroDTO.getPessoa());
    }

    @Test
    public void toEntity_deveConverterDtoParaEntity() {
        MembroDTO membroDTO = new MembroDTO(1L, 2L, 3l);

        Membro membro = membroMapper.toEntity(membroDTO);

        assertEquals(membroDTO.getId(), membro.getId());
        assertEquals(membroDTO.getProjeto(), membro.getProjeto());
        assertEquals(membroDTO.getPessoa(), membro.getPessoa());
    }
}
