package com.exemplo.relacionamento.cliente.repository;

import com.exemplo.relacionamento.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
