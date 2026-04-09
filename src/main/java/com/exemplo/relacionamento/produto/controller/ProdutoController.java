package com.exemplo.relacionamento.produto.controller;

import com.exemplo.relacionamento.produto.dto.ProdutoRequestDTO;
import com.exemplo.relacionamento.produto.dto.ProdutoResponseDTO;
import com.exemplo.relacionamento.produto.entity.Produto;
import com.exemplo.relacionamento.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvar(@RequestBody ProdutoRequestDTO dto){
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>>  listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Produto>> porCategoria(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorCategoria(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Produto>> porNome(@RequestParam String nome){
      return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/categoria-nome")
    public ResponseEntity <List<Produto>> porNomeCategoria(@RequestBody String nome){
        return ResponseEntity.ok(service.buscarPorNomeCategoria(nome));
    }

    @GetMapping("/filtro")
    public ResponseEntity <Produto> filtro(@RequestParam Long id,
                                           @RequestParam String nome){
    return ResponseEntity.ok(service.buscarPorIdENome(id,nome));
    }
}