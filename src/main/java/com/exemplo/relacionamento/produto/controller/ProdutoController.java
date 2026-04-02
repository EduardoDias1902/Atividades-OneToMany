package com.exemplo.relacionamento.produto.controller;

import com.exemplo.relacionamento.produto.dto.ProdutoRequestDTO;
import com.exemplo.relacionamento.produto.dto.ProdutoResponseDTO;
import com.exemplo.relacionamento.produto.entity.Produto;
import com.exemplo.relacionamento.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ProdutoResponseDTO salvar(@RequestBody ProdutoRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @GetMapping("/categoria/{id}")
    public List<Produto> porCategoria(@PathVariable Long id) {
        return service.buscarPorCategoria(id);
    }

    @GetMapping("/nome")
    public List<Produto> porNome(@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }

    @GetMapping("/categoria-nome")
    public List<Produto> porNomeCategoria(@RequestParam String nome) {
        return service.buscarPorNomeCategoria(nome);
    }

    @GetMapping("/filtro")
    public Produto filtro(@RequestParam Long id,
                          @RequestParam String nome) {
        return service.buscarPorIdENome(id, nome);
    }
}