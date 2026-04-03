package com.exemplo.relacionamento.projeto.dto;

import lombok.Data;

@Data
public class TarefaRequestDTO {
    private String titulo;
    private String status;
    private Long projetoId;
}
