package com.exemplo.relacionamento.projeto.controller;

import com.exemplo.relacionamento.projeto.dto.TarefaRequestDTO;
import com.exemplo.relacionamento.projeto.dto.TarefaResponceDTO;
import com.exemplo.relacionamento.projeto.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService service;

    @PostMapping
    public TarefaResponceDTO salvar (@RequestBody TarefaRequestDTO dto){
        return service.salvar(dto);
    }
    @GetMapping
    public List<TarefaResponceDTO> listar(){
        return service.listar();
    }
    @GetMapping("/projeto/{id}")
    public List<TarefaResponceDTO> porProjeto(@PathVariable Long id){
        return service.buscarPorProjeto(id);
    }
    @GetMapping("/filtro")
    public TarefaResponceDTO filtro(@RequestParam Long id,
                                    @RequestParam String titulo){
        return service.buscarPorIdETitulo(id,titulo);
    }
}
