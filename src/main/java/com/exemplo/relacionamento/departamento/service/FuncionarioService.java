package com.exemplo.relacionamento.departamento.service;

import com.exemplo.relacionamento.departamento.dto.FuncionarioRequestDTO;
import com.exemplo.relacionamento.departamento.dto.FuncionarioResponseDTO;
import com.exemplo.relacionamento.departamento.entity.Departamento;
import com.exemplo.relacionamento.departamento.entity.Funcionario;
import com.exemplo.relacionamento.departamento.repository.DepartamentoRepository;
import com.exemplo.relacionamento.departamento.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final DepartamentoRepository departamentoRepository;

    public FuncionarioResponseDTO salvar(FuncionarioRequestDTO dto) {

        Departamento dep = departamentoRepository.findById(dto.getDepartamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento não existe"));

        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());
        f.setDepartamento(dep);

        funcionarioRepository.save(f);

        return new FuncionarioResponseDTO(
                f.getId(),
                f.getNome(),
                dep.getNome()
        );
    }

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscar(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow();
    }

    public List<Funcionario> buscarPorDepartamento(Long id) {
        return funcionarioRepository.findByDepartamentoId(id);
    }

    public List<Funcionario> buscarPorNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public Funcionario buscarPorIdENome(Long id, String nome) {
        return funcionarioRepository.findByIdAndNome(id, nome)
                .orElseThrow();
    }
}