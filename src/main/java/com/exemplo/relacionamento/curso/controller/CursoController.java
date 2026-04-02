package com.exemplo.relacionamento.curso.controller;

import com.exemplo.relacionamento.curso.dto.CursoRequestDTO;
import com.exemplo.relacionamento.curso.dto.CursoResponseDTO;
import com.exemplo.relacionamento.curso.dto.ProfessorRequestDTO;
import com.exemplo.relacionamento.curso.dto.ProfessorResponseDTO;
import com.exemplo.relacionamento.curso.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService service;

    @PostMapping
    public CursoResponseDTO salvar(@RequestBody CursoRequestDTO dto){
        return service.salvar(dto);
    }
    @GetMapping
    public List<CursoResponseDTO> listar(){
        return service.listar();
    }
    @GetMapping("/professor/{id}")
    public List<CursoResponseDTO> porProfessor(@PathVariable Long id){
        return service.buscarPorProfessorId(id);
    }
    @GetMapping("/professor-nome")
    public List<CursoResponseDTO> porNomeProfessor (@RequestParam String nome){
        return service.buscarPorProfessorNome(nome);
    }
    @GetMapping("/filtro")
    public CursoResponseDTO filtro(@RequestParam Long id,
                                   @RequestParam String titulo) {
        return service.buscarPorIdETitulo(id, titulo);
    }

}
