package com.exemplo.relacionamento.projeto.repository;

import com.exemplo.relacionamento.projeto.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
