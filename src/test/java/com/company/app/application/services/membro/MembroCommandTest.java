package com.company.app.application.services.membro;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.mappers.MembroMapper;
import com.company.app.core.bases.UseCaseFacade;
import com.company.app.core.usecases.membro.UcMembroCreate;
import com.company.app.core.usecases.membro.UcMembroDelete;
import com.company.app.core.usecases.membro.UcMembroEdit;
import com.company.app.domain.models.Membro;
import com.company.app.domain.models.Pessoa;
import com.company.app.domain.models.Projeto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MembroCommandTest {

    @Mock
    private UseCaseFacade facade;

    @Mock
    private MembroMapper mapper;

    @InjectMocks
    private MembroCommand membroCommand;

    private MembroDTO membroDTO;
    private Membro membro;
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

        membroDTO = new MembroDTO();
        membroDTO.setId(1L);
        membroDTO.setProjeto(1L);
        membroDTO.setPessoa(1L);

        membro = new Membro();
        membro.setId(1L);
        membro.setProjeto(1L);
        membro.setPessoa(1L);
    }

    @Test
    public void save_deveRetornarMembroDTO_quandoSalvarComSucesso() {
        when(mapper.toEntity(any(MembroDTO.class))).thenReturn(membro);
        when(mapper.toDto(any(Membro.class))).thenReturn(membroDTO);
        when(facade.execute(any(UcMembroCreate.class))).thenReturn(membro);

        MembroDTO result = membroCommand.save(membroDTO);

        assertNotNull(result);
        assertEquals(membroDTO.getId(), result.getId());
        assertEquals(membroDTO.getProjeto(), result.getProjeto());
        assertEquals(membroDTO.getPessoa(), result.getPessoa());
        verify(facade, times(1)).execute(any(UcMembroCreate.class));
        verify(mapper, times(1)).toEntity(membroDTO);
        verify(mapper, times(1)).toDto(membro);
    }

    @Test
    public void update_deveRetornarMembroDTO_quandoAtualizarComSucesso() {
        when(mapper.toEntity(any(MembroDTO.class))).thenReturn(membro);
        when(mapper.toDto(any(Membro.class))).thenReturn(membroDTO);
        when(facade.execute(any(UcMembroEdit.class))).thenReturn(membro);

        MembroDTO result = membroCommand.update(membroDTO);

        assertNotNull(result);
        assertEquals(membroDTO.getId(), result.getId());
        assertEquals(membroDTO.getProjeto(), result.getProjeto());
        assertEquals(membroDTO.getPessoa(), result.getPessoa());
        verify(facade, times(1)).execute(any(UcMembroEdit.class));
        verify(mapper, times(1)).toEntity(membroDTO);
        verify(mapper, times(1)).toDto(membro);
    }

    @Test
    public void delete_deveChamarFacadeExecute_quandoDeletarComSucesso() {
        when(facade.execute(any(UcMembroDelete.class))).thenReturn(null);

        membroCommand.delete(1L);

        verify(facade, times(1)).execute(any(UcMembroDelete.class));
    }
}
