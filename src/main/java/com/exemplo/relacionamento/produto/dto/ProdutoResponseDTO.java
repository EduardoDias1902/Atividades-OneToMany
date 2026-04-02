package com.exemplo.relacionamento.produto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private Double preco;
    private String nomeCategoria;
}