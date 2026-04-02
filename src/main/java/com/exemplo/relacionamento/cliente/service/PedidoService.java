package com.exemplo.relacionamento.cliente.service;

import com.exemplo.relacionamento.cliente.dto.PedidoRequestDTO;
import com.exemplo.relacionamento.cliente.dto.PedidoResponseDTO;
import com.exemplo.relacionamento.cliente.entity.Cliente;
import com.exemplo.relacionamento.cliente.entity.Pedido;
import com.exemplo.relacionamento.cliente.repository.ClienteRepository;
import com.exemplo.relacionamento.cliente.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoResponseDTO salvar(PedidoRequestDTO dto) {


        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));

        Pedido pedido = new Pedido();
        pedido.setDescricao(dto.getDescricao());
        pedido.setDataEntrega(dto.getDataEntrega());
        pedido.setDataGeracao(LocalDateTime.now());
        pedido.setCliente(cliente);

        pedidoRepository.save(pedido);

        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getDescricao(),
                pedido.getDataGeracao(),
                pedido.getDataEntrega(),
                cliente.getNome()
        );
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow();
    }

    public List<Pedido> buscarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public List<Pedido> buscarPorNomeCliente(String nome) {
        return pedidoRepository.findByClienteNome(nome);
    }

    public Pedido buscarPorIdEDescricao(Long id, String descricao) {
        return pedidoRepository.findByIdAndDescricao(id, descricao)
                .orElseThrow();
    }
}