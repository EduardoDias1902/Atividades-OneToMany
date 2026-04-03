package com.exemplo.relacionamento.projeto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String status;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}
