package com.exemplo.relacionamento.departamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartamentoResponseDTO {

    private Long id;
    private String nome;
    private List<String> funcionarios;
}
