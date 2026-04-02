package com.exemplo.relacionamento.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PedidoResponseDTO {
    private Long id;
    private String descricao;
    private LocalDateTime dataGeracao;
    private LocalDateTime dataEntrega;
    private String nomeCliente;

}
