package com.exemplo.relacionamento.departamento.controller;

import com.exemplo.relacionamento.departamento.dto.FuncionarioRequestDTO;
import com.exemplo.relacionamento.departamento.dto.FuncionarioResponseDTO;
import com.exemplo.relacionamento.departamento.entity.Funcionario;
import com.exemplo.relacionamento.departamento.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> salvar(@RequestBody FuncionarioRequestDTO dto) {

        return ResponseEntity
                .status(201)
                .body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity<List<Funcionario>> porDepartamento(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorDepartamento(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Funcionario>> porNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/filtro")
    public ResponseEntity<Funcionario> filtro(@RequestParam Long id,
                                              @RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorIdENome(id, nome));
    }}