package com.company.app.application.services.projeto;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.application.mappers.ProjetoMapper;
import com.company.app.core.bases.UseCaseFacade;
import com.company.app.core.usecases.projeto.UcProjetoCreate;
import com.company.app.core.usecases.projeto.UcProjetoDelete;
import com.company.app.core.usecases.projeto.UcProjetoEdit;
import com.company.app.domain.models.Projeto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjetoCommandTest {

    @Mock
    private ProjetoMapper mapper;

    @Mock
    private UseCaseFacade facade;

    @InjectMocks
    private ProjetoCommand projetoCommand;

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
    public void save_deveRetornarProjetoDTO_quandoSalvarComSucesso() {
        when(mapper.toEntity(any(ProjetoDTO.class))).thenReturn(projeto);
        when(mapper.toDto(any(Projeto.class))).thenReturn(projetoDTO);
        when(facade.execute(any(UcProjetoCreate.class))).thenReturn(projeto);

        ProjetoDTO result = projetoCommand.save(projetoDTO);

        assertNotNull(result);
        assertEquals(projetoDTO.getId(), result.getId());
        assertEquals(projetoDTO.getNome(), result.getNome());
        verify(facade, times(1)).execute(any(UcProjetoCreate.class));
        verify(mapper, times(1)).toEntity(projetoDTO);
        verify(mapper, times(1)).toDto(projeto);
    }

    @Test
    public void update_deveRetornarProjetoDTO_quandoAtualizarComSucesso() {
        when(mapper.toEntity(any(ProjetoDTO.class))).thenReturn(projeto);
        when(mapper.toDto(any(Projeto.class))).thenReturn(projetoDTO);
        when(facade.execute(any(UcProjetoEdit.class))).thenReturn(projeto);

        ProjetoDTO result = projetoCommand.update(projetoDTO);

        assertNotNull(result);
        assertEquals(projetoDTO.getId(), result.getId());
        assertEquals(projetoDTO.getNome(), result.getNome());
        verify(facade, times(1)).execute(any(UcProjetoEdit.class));
        verify(mapper, times(1)).toEntity(projetoDTO);
        verify(mapper, times(1)).toDto(projeto);
    }

    @Test
    public void delete_deveChamarFacadeExecute_quandoDeletarComSucesso() {
        when(facade.execute(any(UcProjetoDelete.class))).thenReturn(null);

        projetoCommand.delete(1L);

        verify(facade, times(1)).execute(any(UcProjetoDelete.class));
    }
}
