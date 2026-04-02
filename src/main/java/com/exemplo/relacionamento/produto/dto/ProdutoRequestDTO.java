package com.exemplo.relacionamento.produto.dto;

import lombok.Data;

@Data
public class ProdutoRequestDTO {

    private String nome;
    private Double preco;
    private Long categoriaId;
}