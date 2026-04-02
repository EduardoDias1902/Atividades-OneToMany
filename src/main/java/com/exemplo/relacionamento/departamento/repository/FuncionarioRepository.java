package com.exemplo.relacionamento.departamento.repository;
import com.exemplo.relacionamento.departamento.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByDepartamentoId(Long id);
    List<Funcionario> findByNome(String nome);
    Optional<Funcionario> findByIdAndNome(Long id, String nome);

}
