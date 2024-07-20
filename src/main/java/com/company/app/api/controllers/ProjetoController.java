package com.company.app.api.controllers;

import com.company.app.application.dtos.ProjetoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projeto")
@RequiredArgsConstructor
@Tag(name = "Projeto Management System", description = "Operations pertaining to project management")
public class ProjetoController {

//    private final IProjetoCommand projetoCommand;
//    private final IProjetoQuery projetoQuery;

    @Operation(summary  = "View a list of available projects")
    @GetMapping("/get-all")
    public ResponseEntity<List<ProjetoDTO>> getAll(@RequestParam("query") Optional<String> query, @RequestParam("pageNumber") Optional<Integer> pageNumber, @RequestParam("pageSize") Optional<Integer> pageSize) {
        try {
            List<ProjetoDTO> projetos = new ArrayList<>();
            if (query.isPresent() && !query.get().isEmpty()) {
//                projetos = projetoQuery.search(query.get()); // Implementar método search na interface IProjetoQuery
            } else {
//                projetos = projetoQuery.findAll();
            }
            return new ResponseEntity<>(projetos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary  = "Get a project by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> getById(@PathVariable Long id) {
        try {
            ProjetoDTO projeto = new ProjetoDTO();
//                    projeto = projetoQuery.findById(id);
            if (projeto != null) {
                return new ResponseEntity<>(projeto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary  = "Get projects by name")
    @GetMapping("/buscar")
    public ResponseEntity<List<ProjetoDTO>> getByNomeProjeto(@RequestParam String nome) {
        try {
            List<ProjetoDTO> projetos = new ArrayList<>();
//            projetos = projetoQuery.findByNome(nome);
            return new ResponseEntity<>(projetos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary  = "Create a new project")
    @PostMapping
    public ResponseEntity<ProjetoDTO> create(@RequestBody ProjetoDTO projetoDto) {
        try {
            ProjetoDTO projeto = new ProjetoDTO();
//            projeto    = projetoCommand.save(projetoDto);
            return new ResponseEntity<>(projeto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary  = "Update a project")
    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> update(@PathVariable Long id, @RequestBody ProjetoDTO projetoDto) {
        try {
            projetoDto.setId(id);
            ProjetoDTO projeto = new ProjetoDTO();
//                    projeto = projetoCommand.save(projetoDto);
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary  = "Delete a project")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
//            projetoCommand.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
