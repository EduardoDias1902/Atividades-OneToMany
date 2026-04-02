package com.exemplo.relacionamento.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteResponseDTO {

    private Long id;
    private String nome;
}
