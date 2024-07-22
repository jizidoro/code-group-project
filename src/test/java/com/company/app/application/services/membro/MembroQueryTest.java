package com.company.app.application.services.membro;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.mappers.MembroMapper;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;
import com.company.app.domain.models.Membro;
import com.company.app.domain.models.Pessoa;
import com.company.app.domain.models.Projeto;
import com.company.app.persistence.repositories.MembroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MembroQueryTest {

    @Mock
    private MembroRepository membroRepository;

    @Mock
    private MembroMapper mapper;

    @InjectMocks
    private MembroQuery membroQuery;

    private Membro membro;
    private MembroDTO membroDTO;
    private Projeto projeto;
    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Pessoa Teste");

        projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");

        membro = new Membro();
        membro.setId(1L);
        membro.setProjeto(projeto.getId());
        membro.setPessoa(pessoa.getId());

        membroDTO = new MembroDTO();
        membroDTO.setId(1L);
        membroDTO.setProjeto(projeto.getId());
        membroDTO.setPessoa(pessoa.getId());
    }

    @Test
    public void findAll_deveRetornarListResultDto_quandoExistemMembros() {
        when(membroRepository.findAll()).thenReturn(List.of(membro));
        when(mapper.toDto(any(Membro.class))).thenReturn(membroDTO);

        ListResultDto<MembroDTO> result = membroQuery.findAll();

        assertNotNull(result);
        assertFalse(result.getData().isEmpty());
        assertEquals(1, result.getData().size());
        assertEquals(membroDTO.getId(), result.getData().get(0).getId());
        verify(membroRepository, times(1)).findAll();
        verify(mapper, times(1)).toDto(membro);
    }

    @Test
    public void findById_deveRetornarSingleResultDto_quandoMembroExiste() {
        when(membroRepository.findById(1L)).thenReturn(Optional.of(membro));
        when(mapper.toDto(any(Membro.class))).thenReturn(membroDTO);

        SingleResultDto<MembroDTO> result = membroQuery.findById(1L);

        assertNotNull(result);
        assertEquals(200, result.getCode());
        assertTrue(result.getSuccess());
        assertNotNull(result.getData());
        assertEquals(membroDTO.getId(), result.getData().getId());
        verify(membroRepository, times(1)).findById(1L);
        verify(mapper, times(1)).toDto(membro);
    }

    @Test
    public void findById_deveRetornarSingleResultDtoComStatusZero_quandoMembroNaoExiste() {
        when(membroRepository.findById(1L)).thenReturn(Optional.empty());

        SingleResultDto<MembroDTO> result = membroQuery.findById(1L);

        assertNotNull(result);
        assertEquals(201, result.getCode());
        assertTrue(result.getSuccess());
        assertNull(result.getData());
        verify(membroRepository, times(1)).findById(1L);
        verify(mapper, times(0)).toDto(any(Membro.class));
    }
}
