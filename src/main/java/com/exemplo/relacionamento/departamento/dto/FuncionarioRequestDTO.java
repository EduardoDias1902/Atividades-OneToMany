package com.exemplo.relacionamento.departamento.dto;

import lombok.Data;
@Data
public class FuncionarioRequestDTO {
    private String nome;
    private Long departamentoId;
}
