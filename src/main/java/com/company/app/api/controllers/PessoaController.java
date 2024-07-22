package com.company.app.api.controllers;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.services.membro.IMembroCommand;
import com.company.app.application.services.pessoa.IPessoaCommand;
import com.company.app.application.services.pessoa.IPessoaQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
@RequiredArgsConstructor
@Tag(name = "Sistema de gerenciamento de pessoas", description = "Operacoes pertencentes ao gerenciamento de pessoas")
public class PessoaController {
    private final IPessoaCommand _pessoaCommand;
    private final IPessoaQuery _pessoaQuery;
    private final IMembroCommand _membrosCommand;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "Ver uma lista das pessoas disponiveis")
    public ResponseEntity<List<PessoaDTO>> getAll() {
        try {
            List<PessoaDTO> pessoas = _pessoaQuery.findAll().getData();
            return new ResponseEntity<>(pessoas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "Buscar uma pessoa por Id")
    public ResponseEntity<PessoaDTO> getById(@PathVariable Long id) {
        try {
            PessoaDTO pessoa = _pessoaQuery.findById(id).getData();
            if (pessoa != null) {
                return new ResponseEntity<>(pessoa, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar pessoas pelo nome")
    public ResponseEntity<List<PessoaDTO>> getByNomePessoa(@RequestParam String nome) {
        try {
            List<PessoaDTO> pessoa = _pessoaQuery.findByName(nome).getData();
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar uma nova pessoa")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO dto) {
        try {
            PessoaDTO pessoa = _pessoaCommand.save(dto);
            return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "Atualizar uma pessoa")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        try {
            dto.setId(id);
            PessoaDTO pessoa = _pessoaCommand.save(dto);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary  = "Apagar uma pessoa")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            _pessoaCommand.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/associar")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Associar uma pessoa a um projeto")
    public ResponseEntity<MembroDTO> associate(@RequestBody MembroDTO dto) {
        try {
            MembroDTO membro = _membrosCommand.save(dto);
            return new ResponseEntity<>(membro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
