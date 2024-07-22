package com.company.app.application.services.pessoa;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.mappers.PessoaMapper;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;
import com.company.app.domain.models.Pessoa;
import com.company.app.persistence.repositories.PessoaRepository;
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
public class PessoaQueryTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper mapper;

    @InjectMocks
    private PessoaQuery pessoaQuery;

    private Pessoa pessoa;
    private PessoaDTO pessoaDTO;

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Pessoa Teste");

        pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(1L);
        pessoaDTO.setNome("Pessoa Teste");
    }

    @Test
    public void findAll_deveRetornarListResultDto_quandoExistemPessoas() {
        when(pessoaRepository.findAll()).thenReturn(List.of(pessoa));
        when(mapper.toDto(any(Pessoa.class))).thenReturn(pessoaDTO);

        ListResultDto<PessoaDTO> result = pessoaQuery.findAll();

        assertNotNull(result);
        assertFalse(result.getData().isEmpty());
        assertEquals(1, result.getData().size());
        assertEquals(pessoaDTO.getId(), result.getData().get(0).getId());
        verify(pessoaRepository, times(1)).findAll();
        verify(mapper, times(1)).toDto(pessoa);
    }

    @Test
    public void findById_deveRetornarSingleResultDto_quandoPessoaExiste() {
        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        when(mapper.toDto(any(Pessoa.class))).thenReturn(pessoaDTO);

        SingleResultDto<PessoaDTO> result = pessoaQuery.findById(1L);

        assertNotNull(result);
        assertEquals(200, result.getCode());
        assertTrue(result.getSuccess());
        assertNotNull(result.getData());
        assertEquals(pessoaDTO.getId(), result.getData().getId());
        verify(pessoaRepository, times(1)).findById(1L);
        verify(mapper, times(1)).toDto(pessoa);
    }

    @Test
    public void findById_deveRetornarSingleResultDtoComStatus_quandoPessoaNaoExiste() {
        when(pessoaRepository.findById(1L)).thenReturn(Optional.empty());

        SingleResultDto<PessoaDTO> result = pessoaQuery.findById(1L);

        assertNotNull(result);
        assertEquals(201, result.getCode());
        assertTrue(result.getSuccess());
        assertNull(result.getData());
        verify(pessoaRepository, times(1)).findById(1L);
        verify(mapper, times(0)).toDto(any(Pessoa.class));
    }
}
