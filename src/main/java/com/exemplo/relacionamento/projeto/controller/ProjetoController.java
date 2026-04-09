package com.exemplo.relacionamento.projeto.controller;

import com.exemplo.relacionamento.projeto.dto.ProjetoResponseDTO;
import com.exemplo.relacionamento.projeto.entity.Projeto;
import com.exemplo.relacionamento.projeto.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> salvar(@RequestBody Projeto projeto) {
        return ResponseEntity.status(201).body(service.salvar(projeto));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}
