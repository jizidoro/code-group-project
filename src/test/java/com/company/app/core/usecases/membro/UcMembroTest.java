package com.company.app.core.usecases.membro;

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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcMembroTest {

    @Mock
    private MembroRepository membroRepository;

    @InjectMocks
    private UcMembroEdit ucMembroEdit;

    @InjectMocks
    private UcMembroDelete ucMembroDelete;

    @InjectMocks
    private UcMembroCreate ucMembroCreate;

    private Membro membro;

    @BeforeEach
    public void setUp() {
        membro = new Membro();
        membro.setId(1L);
        membro.setProjeto(1L);
        membro.setPessoa(1L);
    }

    @Test
    public void execute_deveSalvarMembro_quandoExecutado() throws Exception {
        ucMembroCreate = new UcMembroCreate(membro);
        ucMembroCreate.set_repository(membroRepository);
        when(membroRepository.save(any(Membro.class))).thenReturn(membro);

        Membro result = ucMembroCreate.execute();

        assertEquals(membro.getId(), result.getId());
        assertEquals(membro.getProjeto(), result.getProjeto());
        assertEquals(membro.getPessoa(), result.getPessoa());
        verify(membroRepository, times(1)).save(membro);
    }

    @Test
    public void execute_deveAtualizarMembro_quandoExecutado() throws Exception {
        ucMembroEdit = new UcMembroEdit(membro);
        ucMembroEdit.set_repository(membroRepository);
        when(membroRepository.findById(any(Long.class))).thenReturn(Optional.of(membro));
        when(membroRepository.save(any(Membro.class))).thenReturn(membro);

        Membro result = ucMembroEdit.execute();

        assertEquals(membro.getId(), result.getId());
        assertEquals(membro.getProjeto(), result.getProjeto());
        assertEquals(membro.getPessoa(), result.getPessoa());
        verify(membroRepository, times(1)).findById(membro.getId());
        verify(membroRepository, times(1)).save(membro);
    }

    @Test
    public void execute_deveDeletarMembro_quandoExecutado() throws Exception {
        ucMembroDelete = new UcMembroDelete(1L);
        ucMembroDelete.set_repository(membroRepository);
        ucMembroDelete.execute();

        verify(membroRepository, times(1)).deleteById(1L);
    }
}
