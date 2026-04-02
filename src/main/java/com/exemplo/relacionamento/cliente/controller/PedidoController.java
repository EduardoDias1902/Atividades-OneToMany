package com.exemplo.relacionamento.cliente.controller;
import com.exemplo.relacionamento.cliente.dto.PedidoRequestDTO;
import com.exemplo.relacionamento.cliente.dto.PedidoResponseDTO;
import com.exemplo.relacionamento.cliente.entity.Pedido;
import com.exemplo.relacionamento.cliente.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public PedidoResponseDTO salvar(@RequestBody PedidoRequestDTO dto){
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/cliente/{id}")
    public List<Pedido> porCliente(@PathVariable Long id){
        return service.buscarPorCliente(id);
    }
    @GetMapping("/cliente-nome")
    public List<Pedido> porNomeCliente(@RequestParam String nome){
        return service.buscarPorNomeCliente(nome);
    }
    @GetMapping("/filtro")
    public Pedido filtro(@RequestParam Long id,
                         @RequestParam String descricao){
        return service.buscarPorIdEDescricao(id,descricao);
    }

}
