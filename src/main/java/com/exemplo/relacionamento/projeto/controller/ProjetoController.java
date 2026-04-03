package com.exemplo.relacionamento.projeto.controller;

import com.exemplo.relacionamento.projeto.dto.ProjetoResponseDTO;
import com.exemplo.relacionamento.projeto.entity.Projeto;
import com.exemplo.relacionamento.projeto.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ProjetoResponseDTO salvar(@RequestBody Projeto projeto){
        return service.salvar(projeto);
    }
    @GetMapping
    public List<ProjetoResponseDTO> Listar(){
        return service.listar();
    }

}
