package com.exemplo.relacionamento.departamento.controller;

import com.exemplo.relacionamento.departamento.dto.DepartamentoResponseDTO;
import com.exemplo.relacionamento.departamento.entity.Departamento;
import com.exemplo.relacionamento.departamento.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public Departamento salvar(@RequestBody Departamento d) {
        return service.salvar(d);
    }

    @GetMapping
    public List<Departamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Departamento buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @GetMapping("/{id}/funcionarios")
    public DepartamentoResponseDTO buscarComFuncionarios(@PathVariable Long id) {
        return service.buscarComFuncionarios(id);
    }
}