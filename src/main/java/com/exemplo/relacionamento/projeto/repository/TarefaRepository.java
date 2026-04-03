package com.exemplo.relacionamento.projeto.repository;

import com.exemplo.relacionamento.projeto.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByProjetoId(Long id);
    Optional<Tarefa> findByIdAndTitulo(Long id,String titulo);
}
