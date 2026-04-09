package com.exemplo.relacionamento.departamento.controller;

import com.exemplo.relacionamento.departamento.dto.DepartamentoResponseDTO;
import com.exemplo.relacionamento.departamento.entity.Departamento;
import com.exemplo.relacionamento.departamento.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public ResponseEntity<Departamento> salvar(@RequestBody Departamento d) {
        return ResponseEntity.status(201)
                .body(service.salvar(d));
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping("/{id}/funcionarios")
    public ResponseEntity<DepartamentoResponseDTO> buscarComFuncionarios(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarComFuncionarios(id));
    }}