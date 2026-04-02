package com.exemplo.relacionamento.departamento.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.Join;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @ManyToOne
    @JoinColumn (name = "departamento_id")
        private Departamento departamento;
}
