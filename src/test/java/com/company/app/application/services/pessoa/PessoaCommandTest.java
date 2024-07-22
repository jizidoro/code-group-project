package com.company.app.application.services.pessoa;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.mappers.PessoaMapper;
import com.company.app.core.bases.UseCaseFacade;
import com.company.app.core.usecases.pessoa.UcPessoaCreate;
import com.company.app.core.usecases.pessoa.UcPessoaDelete;
import com.company.app.core.usecases.pessoa.UcPessoaEdit;
import com.company.app.domain.models.Pessoa;
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
public class PessoaCommandTest {

    @Mock
    private PessoaMapper mapper;

    @Mock
    private UseCaseFacade facade;

    @InjectMocks
    private PessoaCommand pessoaCommand;

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
    public void save_deveRetornarPessoaDTO_quandoSalvarComSucesso() {
        when(mapper.toEntity(any(PessoaDTO.class))).thenReturn(pessoa);
        when(mapper.toDto(any(Pessoa.class))).thenReturn(pessoaDTO);
        when(facade.execute(any(UcPessoaCreate.class))).thenReturn(pessoa);

        PessoaDTO result = pessoaCommand.save(pessoaDTO);

        assertNotNull(result);
        assertEquals(pessoaDTO.getId(), result.getId());
        assertEquals(pessoaDTO.getNome(), result.getNome());
        verify(facade, times(1)).execute(any(UcPessoaCreate.class));
        verify(mapper, times(1)).toEntity(pessoaDTO);
        verify(mapper, times(1)).toDto(pessoa);
    }

    @Test
    public void update_deveRetornarPessoaDTO_quandoAtualizarComSucesso() {
        when(mapper.toEntity(any(PessoaDTO.class))).thenReturn(pessoa);
        when(mapper.toDto(any(Pessoa.class))).thenReturn(pessoaDTO);
        when(facade.execute(any(UcPessoaEdit.class))).thenReturn(pessoa);

        PessoaDTO result = pessoaCommand.update(pessoaDTO);

        assertNotNull(result);
        assertEquals(pessoaDTO.getId(), result.getId());
        assertEquals(pessoaDTO.getNome(), result.getNome());
        verify(facade, times(1)).execute(any(UcPessoaEdit.class));
        verify(mapper, times(1)).toEntity(pessoaDTO);
        verify(mapper, times(1)).toDto(pessoa);
    }

    @Test
    public void delete_deveChamarFacadeExecute_quandoDeletarComSucesso() {
        when(facade.execute(any(UcPessoaDelete.class))).thenReturn(null);

        pessoaCommand.delete(1L);

        verify(facade, times(1)).execute(any(UcPessoaDelete.class));
    }

    @Test
    void save_deveRetornarPessoaDTO_quandoSalvoComSucesso() {
        when(mapper.toEntity(any(PessoaDTO.class))).thenReturn(pessoa);
        when(facade.execute(any(UcPessoaCreate.class))).thenReturn(pessoa);
        when(mapper.toDto(any(Pessoa.class))).thenReturn(pessoaDTO);

        PessoaDTO result = pessoaCommand.save(pessoaDTO);

        assertEquals(pessoaDTO.getId(), result.getId());
        assertEquals(pessoaDTO.getNome(), result.getNome());
        verify(mapper, times(1)).toEntity(pessoaDTO);
        verify(facade, times(1)).execute(any(UcPessoaCreate.class));
        verify(mapper, times(1)).toDto(pessoa);
    }

    @Test
    void update_deveRetornarPessoaDTO_quandoAtualizadoComSucesso() {
        when(mapper.toEntity(any(PessoaDTO.class))).thenReturn(pessoa);
        when(facade.execute(any(UcPessoaEdit.class))).thenReturn(pessoa);
        when(mapper.toDto(any(Pessoa.class))).thenReturn(pessoaDTO);

        PessoaDTO result = pessoaCommand.update(pessoaDTO);

        assertEquals(pessoaDTO.getId(), result.getId());
        assertEquals(pessoaDTO.getNome(), result.getNome());
        verify(mapper, times(1)).toEntity(pessoaDTO);
        verify(facade, times(1)).execute(any(UcPessoaEdit.class));
        verify(mapper, times(1)).toDto(pessoa);
    }

    @Test
    void delete_deveChamarFacadeExecute_quandoDeletadoComSucesso() {
        when(facade.execute(any(UcPessoaDelete.class))).thenReturn(null);

        pessoaCommand.delete(1L);

        verify(facade, times(1)).execute(any(UcPessoaDelete.class));
    }
}
