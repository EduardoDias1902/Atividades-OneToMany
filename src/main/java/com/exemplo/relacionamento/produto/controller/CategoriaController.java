package com.exemplo.relacionamento.produto.controller;

import com.exemplo.relacionamento.produto.entity.Categoria;
import com.exemplo.relacionamento.produto.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity <Categoria> salvar(@RequestBody Categoria categoria){
        return ResponseEntity.status(201).body(service.salvar(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

}