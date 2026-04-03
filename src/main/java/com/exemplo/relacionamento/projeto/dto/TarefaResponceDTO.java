package com.exemplo.relacionamento.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TarefaResponceDTO {
    private Long id;
    private String titulo;
    private String status;
    private String nomeProjeto;
}
