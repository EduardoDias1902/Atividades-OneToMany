package com.exemplo.relacionamento.projeto.service;

import com.exemplo.relacionamento.projeto.dto.TarefaRequestDTO;
import com.exemplo.relacionamento.projeto.dto.TarefaResponceDTO;
import com.exemplo.relacionamento.projeto.entity.Projeto;
import com.exemplo.relacionamento.projeto.entity.Tarefa;
import com.exemplo.relacionamento.projeto.repository.ProjetoRepository;
import com.exemplo.relacionamento.projeto.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final ProjetoRepository projetoRepository;

    public TarefaResponceDTO salvar(TarefaRequestDTO dto){
        Projeto projeto = projetoRepository.findById(dto.getProjetoId())
                .orElseThrow(() -> new RuntimeException("Projeto não existe"));

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setStatus(dto.getStatus());
        tarefa.setProjeto(projeto);

        tarefaRepository.save(tarefa);

        return new TarefaResponceDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getStatus(),
                projeto.getNome()
        );
    }
    public List<TarefaResponceDTO> listar(){
        return tarefaRepository.findAll()
                .stream()
                .map(tarefa -> new TarefaResponceDTO(
                        tarefa.getId(),
                        tarefa.getTitulo(),
                        tarefa.getStatus(),
                        tarefa.getProjeto().getNome()
                ))
                .collect(Collectors.toList());
    }
    public List<TarefaResponceDTO> buscarPorProjeto(Long id){
        return tarefaRepository.findByProjetoId(id)
                .stream()
                .map(tarefa -> new TarefaResponceDTO(
                        tarefa.getId(),
                        tarefa.getTitulo(),
                        tarefa.getStatus(),
                        tarefa.getProjeto().getNome()
                ))
                .collect(Collectors.toList());
    }
    public TarefaResponceDTO buscarPorIdETitulo(Long id,String titulo){
        Tarefa tarefa = tarefaRepository.findByIdAndTitulo(id,titulo)
                .orElseThrow();

        return new TarefaResponceDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getStatus(),
                tarefa.getProjeto().getNome()
        );
    }
}
