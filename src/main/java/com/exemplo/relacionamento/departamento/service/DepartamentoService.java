package com.exemplo.relacionamento.departamento.service;

import com.exemplo.relacionamento.departamento.dto.DepartamentoResponseDTO;
import com.exemplo.relacionamento.departamento.entity.Departamento;
import com.exemplo.relacionamento.departamento.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;

    public Departamento salvar(Departamento d) {
        return repository.save(d);
    }

    public List<Departamento> listar() {
        return repository.findAll();
    }

    public Departamento buscar(Long id) {
        return repository.findById(id).orElseThrow();
    }

    // DESAFIO EXTRA
    public DepartamentoResponseDTO buscarComFuncionarios(Long id) {
        Departamento d = buscar(id);

        return new DepartamentoResponseDTO(
                d.getId(),
                d.getNome(),
                d.getFuncionarios()
                        .stream()
                        .map(f -> f.getNome())
                        .collect(Collectors.toList())
        );
    }
}