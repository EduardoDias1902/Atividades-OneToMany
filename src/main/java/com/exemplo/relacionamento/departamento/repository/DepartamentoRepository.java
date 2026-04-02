package com.exemplo.relacionamento.departamento.repository;

import com.exemplo.relacionamento.departamento.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
