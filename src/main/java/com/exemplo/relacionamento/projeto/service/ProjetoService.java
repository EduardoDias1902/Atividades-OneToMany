package com.exemplo.relacionamento.projeto.service;

import com.exemplo.relacionamento.projeto.dto.ProjetoResponseDTO;
import com.exemplo.relacionamento.projeto.entity.Projeto;
import com.exemplo.relacionamento.projeto.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetoService {
    private final ProjetoRepository repository;

    public ProjetoResponseDTO salvar (Projeto projeto){
        Projeto p = repository.save(projeto);

        return new ProjetoResponseDTO(
                p.getId(),
                p.getNome(),
                p.getDescricao()
        );
    }
    public List<ProjetoResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(projeto -> new ProjetoResponseDTO(
                        projeto.getId(),
                        projeto.getNome(),
                        projeto.getDescricao()
                ))
                .collect(Collectors.toList());
    }
    public Projeto buscarEntidade(Long id){
        return repository.findById(id).orElseThrow();
        }
    }

