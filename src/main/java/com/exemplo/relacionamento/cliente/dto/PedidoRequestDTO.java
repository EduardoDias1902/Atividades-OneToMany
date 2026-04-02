package com.exemplo.relacionamento.cliente.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoRequestDTO {

    private String descricao;
    private LocalDateTime dataEntrega;
    private Long clienteId;
}
