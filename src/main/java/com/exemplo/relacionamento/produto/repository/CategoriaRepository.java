package com.exemplo.relacionamento.produto.repository;

import com.exemplo.relacionamento.produto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}