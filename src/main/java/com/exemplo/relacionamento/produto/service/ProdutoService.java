package com.exemplo.relacionamento.produto.service;

import com.exemplo.relacionamento.produto.dto.ProdutoRequestDTO;
import com.exemplo.relacionamento.produto.dto.ProdutoResponseDTO;
import com.exemplo.relacionamento.produto.entity.Categoria;
import com.exemplo.relacionamento.produto.entity.Produto;
import com.exemplo.relacionamento.produto.repository.CategoriaRepository;
import com.exemplo.relacionamento.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        // 🔴 VALIDAÇÃO
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não existe"));

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(categoria);

        produtoRepository.save(produto);

        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                categoria.getNome()
        );
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto buscar(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    public List<Produto> buscarPorCategoria(Long id) {
        return produtoRepository.findByCategoriaId(id);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> buscarPorNomeCategoria(String nome) {
        return produtoRepository.findByCategoriaNome(nome);
    }

    public Produto buscarPorIdENome(Long id, String nome) {
        return produtoRepository.findByIdAndNome(id, nome)
                .orElseThrow();
    }
}