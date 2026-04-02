package com.exemplo.relacionamento.curso.service;

import com.exemplo.relacionamento.curso.dto.ProfessorRequestDTO;
import com.exemplo.relacionamento.curso.dto.ProfessorResponseDTO;
import com.exemplo.relacionamento.curso.entity.Professor;
import com.exemplo.relacionamento.curso.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository repository;

    public ProfessorResponseDTO salvar(ProfessorRequestDTO dto){

        Professor p = new Professor();
        p.setNome(dto.getNome());

        repository.save(p);

        return new ProfessorResponseDTO(p.getId(),p.getNome());
    }
    public List<ProfessorResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(p -> new ProfessorResponseDTO(p.getId(),p.getNome()))
                .collect(Collectors.toList());
    }
    public Professor buscarEntidade(Long id){
        return repository.findById(id).orElseThrow();
    }
}
