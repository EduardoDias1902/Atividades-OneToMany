package com.exemplo.relacionamento.cliente.controller;

import com.exemplo.relacionamento.cliente.entity.Cliente;
import com.exemplo.relacionamento.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
 private final ClienteService service;

 @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){
     return service.salvar(cliente);
 }
 @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id){
     return service.buscar(id);
 }

}
