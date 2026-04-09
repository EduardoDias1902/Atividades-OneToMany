package com.exemplo.relacionamento.cliente.controller;

import com.exemplo.relacionamento.cliente.entity.Cliente;
import com.exemplo.relacionamento.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
 private final ClienteService service;

 @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
     return ResponseEntity.status(201).body(service.salvar(cliente));
 }
 @GetMapping
 public ResponseEntity<List<Cliente>> listar(){
     return ResponseEntity.ok(service.listar());
 }
 @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id){
     return ResponseEntity.ok(service.buscar(id));
 }

}
