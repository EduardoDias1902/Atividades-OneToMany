package com.exemplo.relacionamento.departamento.controller;

import com.exemplo.relacionamento.departamento.dto.FuncionarioRequestDTO;
import com.exemplo.relacionamento.departamento.dto.FuncionarioResponseDTO;
import com.exemplo.relacionamento.departamento.entity.Funcionario;
import com.exemplo.relacionamento.departamento.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public FuncionarioResponseDTO salvar(@RequestBody FuncionarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @GetMapping("/departamento/{id}")
    public List<Funcionario> porDepartamento(@PathVariable Long id) {
        return service.buscarPorDepartamento(id);
    }

    @GetMapping("/nome")
    public List<Funcionario> porNome(@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }

    @GetMapping("/filtro")
    public Funcionario porIdENome(@RequestParam Long id,
                                  @RequestParam String nome) {
        return service.buscarPorIdENome(id, nome);
    }
}