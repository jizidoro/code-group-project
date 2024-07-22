package com.company.app.api.controllers;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.application.services.projeto.IProjetoCommand;
import com.company.app.application.services.projeto.IProjetoQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projeto")
@RequiredArgsConstructor
@Tag(name = "Sistema de gerenciamento de projetos", description = "Operacoes pertencentes ao gerenciamento de projetos")
public class ProjetoController {
    private final IProjetoCommand _projetoCommand;
    private final IProjetoQuery _projetoQuery;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "Ver uma lista dos projetos disponiveis")
    public ResponseEntity<List<ProjetoDTO>> getAll() {
        try {
            List<ProjetoDTO> projetos = _projetoQuery.findAll().getData();
            return new ResponseEntity<>(projetos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar um projeto por Id")
    public ResponseEntity<ProjetoDTO> getById(@RequestParam Long id) {
        try {
            ProjetoDTO projeto = _projetoQuery.findById(id).getData();
            if (projeto != null) {
                return new ResponseEntity<>(projeto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca um projeto pelo nome")
    public ResponseEntity<List<ProjetoDTO>> getByNomeProjeto(@RequestParam String nome) {
        try {
            List<ProjetoDTO> projeto = _projetoQuery.findByName(nome).getData();
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary  = "Cria um novo projeto")
    public ResponseEntity<ProjetoDTO> create(@RequestBody ProjetoDTO dto) {
        try {
            ProjetoDTO projeto = _projetoCommand.save(dto);
            return new ResponseEntity<>(projeto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar um projeto")
    public ResponseEntity<ProjetoDTO> update(@RequestBody ProjetoDTO dto) {
        try {
            ProjetoDTO projeto = _projetoCommand.save(dto);
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary  = "Apagar um projeto")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            _projetoCommand.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
