//package com.company.app.api.controllers;
//
//import com.company.app.application.dtos.ProjetoDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/projeto")
//@RequiredArgsConstructor
//public class ProjetoController {
//
//    private final IProjetoCommand projetoCommand;
//    private final IProjetoQuery projetoQuery;
//
//    @GetMapping("/get-all")
//    public ResponseEntity<List<ProjetoDTO>> getAll(@RequestParam("pageNumber") Optional<Integer> pageNumber, @RequestParam("pageSize") Optional<Integer> pageSize) {
//        try {
//            List<ProjetoDTO> projetos = projetoQuery.findAll();
//            return new ResponseEntity<>(projetos, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ProjetoDTO> getById(@PathVariable Long id) {
//        try {
//            ProjetoDTO projeto = projetoQuery.findById(id);
//            if (projeto != null) {
//                return new ResponseEntity<>(projeto, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<ProjetoDTO> create(@RequestBody ProjetoDTO projetoDto) {
//        try {
//            ProjetoDTO projeto = projetoCommand.save(projetoDto);
//            return new ResponseEntity<>(projeto, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ProjetoDTO> update(@PathVariable Long id, @RequestBody ProjetoDTO projetoDto) {
//        try {
//            projetoDto.setId(id);
//            ProjetoDTO projeto = projetoCommand.save(projetoDto);
//            return new ResponseEntity<>(projeto, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        try {
//            projetoCommand.delete(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
