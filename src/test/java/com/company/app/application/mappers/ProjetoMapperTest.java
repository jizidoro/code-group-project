package com.company.app.application.mappers;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.domain.models.Projeto;
import com.company.app.domain.models.Pessoa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjetoMapperTest {

    private final ProjetoMapper projetoMapper = ProjetoMapper.INSTANCE;

    @Test
    public void toDto_deveConverterEntityParaDto() {
        Projeto projeto = new Projeto(1L, "Projeto Teste", LocalDate.now(), LocalDate.now().plusDays(10), LocalDate.now().plusDays(20), "Descrição", "Status", 1000.0f, "Risco", 2L);

        ProjetoDTO projetoDTO = projetoMapper.toDto(projeto);

        assertEquals(projeto.getId(), projetoDTO.getId());
        assertEquals(projeto.getNome(), projetoDTO.getNome());
        assertEquals(projeto.getDataInicio(), projetoDTO.getDataInicio());
        assertEquals(projeto.getPrevisaoFim(), projetoDTO.getPrevisaoFim());
        assertEquals(projeto.getDataFim(), projetoDTO.getDataFim());
        assertEquals(projeto.getDescricao(), projetoDTO.getDescricao());
        assertEquals(projeto.getStatus(), projetoDTO.getStatus());
        assertEquals(projeto.getOrcamento(), projetoDTO.getOrcamento());
        assertEquals(projeto.getRisco(), projetoDTO.getRisco());
        assertEquals(projeto.getGerente(), projetoDTO.getGerente());
    }

    @Test
    public void toEntity_deveConverterDtoParaEntity() {
        ProjetoDTO projetoDTO = new ProjetoDTO(1L, "Projeto Teste", LocalDate.now(), LocalDate.now().plusDays(10), LocalDate.now().plusDays(20), "Descrição", "Status", 1000.0f, "Risco", 3L);

        Projeto projeto = projetoMapper.toEntity(projetoDTO);

        assertEquals(projetoDTO.getId(), projeto.getId());
        assertEquals(projetoDTO.getNome(), projeto.getNome());
        assertEquals(projetoDTO.getDataInicio(), projeto.getDataInicio());
        assertEquals(projetoDTO.getPrevisaoFim(), projeto.getPrevisaoFim());
        assertEquals(projetoDTO.getDataFim(), projeto.getDataFim());
        assertEquals(projetoDTO.getDescricao(), projeto.getDescricao());
        assertEquals(projetoDTO.getStatus(), projeto.getStatus());
        assertEquals(projetoDTO.getOrcamento(), projeto.getOrcamento());
        assertEquals(projetoDTO.getRisco(), projeto.getRisco());
        assertEquals(projetoDTO.getGerente(), projeto.getGerente());
    }
}
