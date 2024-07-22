package com.company.app.core.usecases.projeto;

import com.company.app.domain.models.Projeto;
import com.company.app.domain.models.Pessoa;
import com.company.app.persistence.repositories.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcProjetoTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @InjectMocks
    private UcProjetoCreate ucProjetoCreate;

    @InjectMocks
    private UcProjetoDelete ucProjetoDelete;

    @InjectMocks
    private UcProjetoEdit ucProjetoEdit;

    private Projeto projeto;

    @BeforeEach
    public void setUp() {
        projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");
        projeto.setDataInicio(LocalDate.now());
        projeto.setPrevisaoFim(LocalDate.now().plusDays(10));
        projeto.setDescricao("Descrição do Projeto Teste");
        projeto.setStatus("Em andamento");
        projeto.setOrcamento(1000.0f);
        projeto.setRisco("Alto");
        projeto.setGerente(1L);
    }

    @Test
    public void execute_deveSalvarProjeto_quandoExecutado() throws Exception {
        ucProjetoCreate = new UcProjetoCreate(projeto);
        ucProjetoCreate.set_repository(projetoRepository);
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        Projeto result = ucProjetoCreate.execute();

        assertEquals(projeto.getId(), result.getId());
        assertEquals(projeto.getNome(), result.getNome());
        assertEquals(projeto.getDataInicio(), result.getDataInicio());
        assertEquals(projeto.getPrevisaoFim(), result.getPrevisaoFim());
        assertEquals(projeto.getDescricao(), result.getDescricao());
        assertEquals(projeto.getStatus(), result.getStatus());
        assertEquals(projeto.getOrcamento(), result.getOrcamento());
        assertEquals(projeto.getRisco(), result.getRisco());
        assertEquals(projeto.getGerente(), result.getGerente());
        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    public void execute_deveDeletarProjeto_quandoExecutado() throws Exception {
        ucProjetoDelete = new UcProjetoDelete(1L);
        ucProjetoDelete.set_repository(projetoRepository);
        ucProjetoDelete.execute();

        verify(projetoRepository, times(1)).deleteById(1L);
    }

    @Test
    public void execute_deveAtualizarProjeto_quandoExecutado() throws Exception {
        ucProjetoEdit = new UcProjetoEdit(projeto);
        ucProjetoEdit.set_repository(projetoRepository);
        when(projetoRepository.findById(any(Long.class))).thenReturn(Optional.of(projeto));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        Projeto result = ucProjetoEdit.execute();

        assertEquals(projeto.getId(), result.getId());
        assertEquals(projeto.getNome(), result.getNome());
        assertEquals(projeto.getDataInicio(), result.getDataInicio());
        assertEquals(projeto.getPrevisaoFim(), result.getPrevisaoFim());
        assertEquals(projeto.getDescricao(), result.getDescricao());
        assertEquals(projeto.getStatus(), result.getStatus());
        assertEquals(projeto.getOrcamento(), result.getOrcamento());
        assertEquals(projeto.getRisco(), result.getRisco());
        assertEquals(projeto.getGerente(), result.getGerente());
        verify(projetoRepository, times(1)).findById(projeto.getId());
        verify(projetoRepository, times(1)).save(projeto);
    }
}
