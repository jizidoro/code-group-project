package com.company.app.application.services.projeto;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.application.mappers.ProjetoMapper;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;
import com.company.app.domain.models.Projeto;
import com.company.app.persistence.repositories.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjetoQueryTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private ProjetoMapper mapper;

    @InjectMocks
    private ProjetoQuery projetoQuery;

    private Projeto projeto;
    private ProjetoDTO projetoDTO;

    @BeforeEach
    public void setUp() {
        projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");

        projetoDTO = new ProjetoDTO();
        projetoDTO.setId(1L);
        projetoDTO.setNome("Projeto Teste");
    }

    @Test
    public void findAll_deveRetornarListResultDto_quandoExistemProjetos() {
        when(projetoRepository.findAll()).thenReturn(List.of(projeto));
        when(mapper.toDto(any(Projeto.class))).thenReturn(projetoDTO);

        ListResultDto<ProjetoDTO> result = projetoQuery.findAll();

        assertNotNull(result);
        assertFalse(result.getData().isEmpty());
        assertEquals(1, result.getData().size());
        assertEquals(projetoDTO.getId(), result.getData().get(0).getId());
        verify(projetoRepository, times(1)).findAll();
        verify(mapper, times(1)).toDto(projeto);
    }

    @Test
    public void findById_deveRetornarSingleResultDto_quandoProjetoExiste() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        when(mapper.toDto(any(Projeto.class))).thenReturn(projetoDTO);

        SingleResultDto<ProjetoDTO> result = projetoQuery.findById(1L);

        assertNotNull(result);
        assertEquals(200, result.getCode());
        assertTrue(result.getSuccess());
        assertNotNull(result.getData());
        assertEquals(projetoDTO.getId(), result.getData().getId());
        verify(projetoRepository, times(1)).findById(1L);
        verify(mapper, times(1)).toDto(projeto);
    }

    @Test
    public void findById_deveRetornarSingleResultDtoComStatusZero_quandoProjetoNaoExiste() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.empty());

        SingleResultDto<ProjetoDTO> result = projetoQuery.findById(1L);

        assertNotNull(result);
        assertEquals(201, result.getCode());
        assertTrue(result.getSuccess());
        assertNull(result.getData());
        verify(projetoRepository, times(1)).findById(1L);
        verify(mapper, times(0)).toDto(any(Projeto.class));
    }
}
