package com.company.app.api.controllers;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.dtos.ProjetoMembroDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/membros")
@RequiredArgsConstructor
@Tag(name = "Member Management System", description = "Operations pertaining to member management")
public class MembroController {

//    private final IMembroCommand membroCommand;
//    private final IProjetoMembroCommand projetoMembroCommand;

    @Operation(summary = "Create a new member")
    @PostMapping
    public ResponseEntity<MembroDTO> create(@RequestBody MembroDTO membroDto) {
        try {
            MembroDTO membro = new MembroDTO();
//            membro = membroCommand.save(membroDto);
            return new ResponseEntity<>(membro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Associate a member to a project")
    @PostMapping("/associar")
    public ResponseEntity<ProjetoMembroDTO> associate(@RequestBody ProjetoMembroDTO projetoMembroDto) {
        try {
            ProjetoMembroDTO projetoMembro = new ProjetoMembroDTO();
//            projetoMembro = projetoMembroCommand.associate(projetoMembroDto);
            return new ResponseEntity<>(projetoMembro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
