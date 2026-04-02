package com.exemplo.relacionamento.curso.controller;

import com.exemplo.relacionamento.curso.dto.ProfessorRequestDTO;
import com.exemplo.relacionamento.curso.dto.ProfessorResponseDTO;
import com.exemplo.relacionamento.curso.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ProfessorResponseDTO salvar (@RequestBody ProfessorRequestDTO dto){
        return service.salvar(dto);
    }
    @GetMapping
    public List<ProfessorResponseDTO> listar(){
        return service.listar();
    }

    }

