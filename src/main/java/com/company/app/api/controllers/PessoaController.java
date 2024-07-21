package com.company.app.api.controllers;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.services.membro.IMembroCommand;
import com.company.app.application.services.pessoa.IPessoaCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoa")
@RequiredArgsConstructor
@Tag(name = "Sistema de gerenciamento de pessoas", description = "Operacoes pertencentes ao gerenciamento de pessoas")
public class PessoaController {
    private final IPessoaCommand _pessoaCommand;
    private final IMembroCommand _membrosCommand;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar uma nova pessoa")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
        try {
            PessoaDTO pessoa = _pessoaCommand.save(pessoaDTO);
            return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/associar")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Associar uma pessoa a um projeto")
    public ResponseEntity<MembroDTO> associate(@RequestBody MembroDTO membroDto) {
        try {
            MembroDTO membro = _membrosCommand.save(membroDto);
            return new ResponseEntity<>(membro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
