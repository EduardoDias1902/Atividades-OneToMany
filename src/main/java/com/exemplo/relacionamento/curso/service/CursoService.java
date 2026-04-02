package com.exemplo.relacionamento.curso.service;

import com.exemplo.relacionamento.curso.dto.CursoRequestDTO;
import com.exemplo.relacionamento.curso.dto.CursoResponseDTO;
import com.exemplo.relacionamento.curso.entity.Curso;
import com.exemplo.relacionamento.curso.entity.Professor;
import com.exemplo.relacionamento.curso.repository.CursoRepository;
import com.exemplo.relacionamento.curso.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    public CursoResponseDTO salvar(CursoRequestDTO dto) {

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não existe"));

        Curso curso = new Curso();
        curso.setTitulo(dto.getTitulo());
        curso.setProfessor(professor);

        cursoRepository.save(curso);

        return new CursoResponseDTO(
                curso.getId(),
                curso.getTitulo(),
                professor.getNome()
        );
    }

    public List<CursoResponseDTO> listar() {
        return cursoRepository.findAll()
                .stream()
                .map(c -> new CursoResponseDTO(
                        c.getId(),
                        c.getTitulo(),
                        c.getProfessor().getNome()
                ))
                .collect(Collectors.toList());
    }

    public List<CursoResponseDTO> buscarPorProfessorId(Long id) {
        return cursoRepository.findByProfessorId(id)
                .stream()
                .map(c -> new CursoResponseDTO(
                        c.getId(),
                        c.getTitulo(),
                        c.getProfessor().getNome()
                ))
                .collect(Collectors.toList());
    }

    public List<CursoResponseDTO> buscarPorProfessorNome(String nome) {
        return cursoRepository.findByProfessorNome(nome)
                .stream()
                .map(c -> new CursoResponseDTO(
                        c.getId(),
                        c.getTitulo(),
                        c.getProfessor().getNome()
                ))
                .collect(Collectors.toList());
    }

    public CursoResponseDTO buscarPorIdETitulo(Long id, String titulo) {
        Curso c = cursoRepository.findByIdAndTitulo(id, titulo)
                .orElseThrow();

        return new CursoResponseDTO(
                c.getId(),
                c.getTitulo(),
                c.getProfessor().getNome()
        );
    }
}