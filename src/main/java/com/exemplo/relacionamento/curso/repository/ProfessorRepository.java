package com.exemplo.relacionamento.curso.repository;

import com.exemplo.relacionamento.curso.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
