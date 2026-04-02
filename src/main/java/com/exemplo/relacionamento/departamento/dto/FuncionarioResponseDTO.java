package com.exemplo.relacionamento.departamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuncionarioResponseDTO {
    private Long id;
    private String nome;
    private String nomeDepartamento;
}
