package com.exemplo.relacionamento.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CursoResponseDTO {
    private Long id;
    private String titulo;
    private String nomeProfessor;
}
