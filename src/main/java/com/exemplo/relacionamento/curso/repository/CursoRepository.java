package com.exemplo.relacionamento.curso.repository;

import com.exemplo.relacionamento.curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByProfessorId(Long id);
    List<Curso> findByProfessorNome(String nome);

    Optional<Curso> findByIdAndTitulo(Long id,String titulo);
}
