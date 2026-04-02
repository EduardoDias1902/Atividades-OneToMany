package com.exemplo.relacionamento.cliente.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}
