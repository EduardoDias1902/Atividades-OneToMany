package com.exemplo.relacionamento.curso.controller;

import com.exemplo.relacionamento.curso.dto.CursoRequestDTO;
import com.exemplo.relacionamento.curso.dto.CursoResponseDTO;
import com.exemplo.relacionamento.curso.dto.ProfessorRequestDTO;
import com.exemplo.relacionamento.curso.dto.ProfessorResponseDTO;
import com.exemplo.relacionamento.curso.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService service;

    @PostMapping
    public ResponseEntity<CursoResponseDTO> salvar(@RequestBody CursoRequestDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<List<CursoResponseDTO>> porProfessor(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorProfessorId(id));
    }

    @GetMapping("/professor-nome")
    public ResponseEntity<List<CursoResponseDTO>> porNomeProfessor(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorProfessorNome(nome));
    }

    @GetMapping("/filtro")
    public ResponseEntity<CursoResponseDTO> filtro(@RequestParam Long id,
                                                   @RequestParam String titulo) {
        return ResponseEntity.ok(service.buscarPorIdETitulo(id, titulo));
    }}