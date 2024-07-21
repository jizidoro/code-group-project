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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<ProjetoDTO>> getAll(@RequestParam("query") Optional<String> query, @RequestParam("pageNumber") Optional<Integer> pageNumber, @RequestParam("pageSize") Optional<Integer> pageSize) {
        try {
            List<ProjetoDTO> projetos = new ArrayList<>();
            if (query.isPresent() && !query.get().isEmpty()) {
                //projetos = _projetoQuery.findById(query.get()); // Implementar método search na interface IProjetoQuery
            } else {
                projetos = _projetoQuery.findAll().getData();
            }
            return new ResponseEntity<>(projetos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "Buscar um projeto por Id")
    public ResponseEntity<ProjetoDTO> getById(@PathVariable Long id) {
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
            List<ProjetoDTO> projeto = new ArrayList<>();
//            projeto = projetoQuery.findByNome(nome);
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary  = "Cria um novo projeto")
    public ResponseEntity<ProjetoDTO> create(@RequestBody ProjetoDTO projetoDto) {
        try {
            ProjetoDTO projeto = _projetoCommand.save(projetoDto);
            return new ResponseEntity<>(projeto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "Atualiza um novo projeto")
    public ResponseEntity<ProjetoDTO> update(@PathVariable Long id, @RequestBody ProjetoDTO projetoDto) {
        try {
            projetoDto.setId(id);
            ProjetoDTO projeto = _projetoCommand.save(projetoDto);
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary  = "Delete a project")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            _projetoCommand.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
