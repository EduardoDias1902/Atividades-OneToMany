package com.exemplo.relacionamento.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjetoResponseDTO {
    private Long id;
    String nome;
    private String descricao;

}
