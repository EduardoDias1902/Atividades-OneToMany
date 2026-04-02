package com.exemplo.relacionamento.produto.repository;

import com.exemplo.relacionamento.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoriaId(Long id);

    List<Produto> findByCategoriaNome(String nome);

    List<Produto> findByNome(String nome);

    Optional<Produto> findByIdAndNome(Long id, String nome);
}