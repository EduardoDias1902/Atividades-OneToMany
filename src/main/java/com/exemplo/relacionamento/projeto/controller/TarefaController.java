package com.exemplo.relacionamento.projeto.controller;

import com.exemplo.relacionamento.projeto.dto.TarefaRequestDTO;
import com.exemplo.relacionamento.projeto.dto.TarefaResponseDTO;
import com.exemplo.relacionamento.projeto.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> salvar(@RequestBody TarefaRequestDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity<List<TarefaResponseDTO>> porProjeto(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorProjeto(id));
    }

    @GetMapping("/filtro")
    public ResponseEntity<TarefaResponseDTO> filtro(@RequestParam Long id,
                                                    @RequestParam String titulo) {
        return ResponseEntity.ok(service.buscarPorIdETitulo(id, titulo));
    }
}
