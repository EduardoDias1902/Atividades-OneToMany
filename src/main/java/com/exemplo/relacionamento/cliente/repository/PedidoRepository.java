package com.exemplo.relacionamento.cliente.repository;

import com.exemplo.relacionamento.cliente.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteNome(String Nome);

    List<Pedido> findByClienteId(Long id);

    Optional<Pedido> findByIdAndDescricao(Long id,String descricao);
}
