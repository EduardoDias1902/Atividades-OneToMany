package com.exemplo.relacionamento.curso.controller;

import com.exemplo.relacionamento.curso.dto.ProfessorRequestDTO;
import com.exemplo.relacionamento.curso.dto.ProfessorResponseDTO;
import com.exemplo.relacionamento.curso.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> salvar(@RequestBody ProfessorRequestDTO dto){
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    }

