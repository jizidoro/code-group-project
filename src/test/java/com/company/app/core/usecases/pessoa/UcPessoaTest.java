package com.company.app.core.usecases.pessoa;

import com.company.app.domain.models.Pessoa;
import com.company.app.persistence.repositories.PessoaRepository;
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
public class UcPessoaTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private UcPessoaCreate ucPessoaCreate;

    @InjectMocks
    private UcPessoaDelete ucPessoaDelete;

    @InjectMocks
    private UcPessoaEdit ucPessoaEdit;

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Nome Teste");
        pessoa.setDataNascimento(LocalDate.of(1990, 1, 1));
        pessoa.setCpf("123.456.789-00");
        pessoa.setFuncionario(true);
        pessoa.setGerente(false);
    }

    @Test
    public void execute_deveSalvarPessoa_quandoExecutado() throws Exception {
        ucPessoaCreate = new UcPessoaCreate(pessoa);
        ucPessoaCreate.set_repository(pessoaRepository);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa result = ucPessoaCreate.execute();

        assertEquals(pessoa.getId(), result.getId());
        assertEquals(pessoa.getNome(), result.getNome());
        assertEquals(pessoa.getDataNascimento(), result.getDataNascimento());
        assertEquals(pessoa.getCpf(), result.getCpf());
        assertEquals(pessoa.getFuncionario(), result.getFuncionario());
        assertEquals(pessoa.getGerente(), result.getGerente());
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    public void execute_deveDeletarPessoa_quandoExecutado() throws Exception {
        ucPessoaDelete = new UcPessoaDelete(1L);
        ucPessoaDelete.set_repository(pessoaRepository);
        ucPessoaDelete.execute();

        verify(pessoaRepository, times(1)).deleteById(1L);
    }

    @Test
    public void execute_deveAtualizarPessoa_quandoExecutado() throws Exception {
        ucPessoaEdit = new UcPessoaEdit(pessoa);
        ucPessoaEdit.set_repository(pessoaRepository);

        when(pessoaRepository.findById(any(Long.class))).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa result = ucPessoaEdit.execute();

        assertEquals(pessoa.getId(), result.getId());
        assertEquals(pessoa.getNome(), result.getNome());
        assertEquals(pessoa.getDataNascimento(), result.getDataNascimento());
        assertEquals(pessoa.getCpf(), result.getCpf());
        assertEquals(pessoa.getFuncionario(), result.getFuncionario());
        assertEquals(pessoa.getGerente(), result.getGerente());
        verify(pessoaRepository, times(1)).findById(pessoa.getId());
        verify(pessoaRepository, times(1)).save(pessoa);
    }
}
