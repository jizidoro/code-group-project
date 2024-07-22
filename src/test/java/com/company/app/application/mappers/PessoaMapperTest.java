package com.company.app.application.mappers;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.domain.models.Pessoa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaMapperTest {

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Test
    public void toDto_deveConverterEntityParaDto() {
        Pessoa pessoa = new Pessoa(1L, "Pessoa Teste", LocalDate.now(), "123.456.789-00", true, false);

        PessoaDTO pessoaDTO = pessoaMapper.toDto(pessoa);

        assertEquals(pessoa.getId(), pessoaDTO.getId());
        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getDataNascimento(), pessoaDTO.getDataNascimento());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
        assertEquals(pessoa.getFuncionario(), pessoaDTO.getFuncionario());
        assertEquals(pessoa.getGerente(), pessoaDTO.getGerente());
    }

    @Test
    public void toEntity_deveConverterDtoParaEntity() {
        PessoaDTO pessoaDTO = new PessoaDTO(1L, "Pessoa Teste", LocalDate.now(), "123.456.789-00", true, false);

        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);

        assertEquals(pessoaDTO.getId(), pessoa.getId());
        assertEquals(pessoaDTO.getNome(), pessoa.getNome());
        assertEquals(pessoaDTO.getDataNascimento(), pessoa.getDataNascimento());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());
        assertEquals(pessoaDTO.getFuncionario(), pessoa.getFuncionario());
        assertEquals(pessoaDTO.getGerente(), pessoa.getGerente());
    }
}
