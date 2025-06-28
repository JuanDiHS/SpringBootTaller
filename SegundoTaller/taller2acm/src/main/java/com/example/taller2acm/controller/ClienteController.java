package com.example.taller2acm.controller;

import com.example.taller2acm.dto.ClienteDTO;
import com.example.taller2acm.service.IClienteService;
import com.example.taller2acm.util.ClienteMapper;

import jakarta.validation.Valid;

import com.example.taller2acm.persistence.entity.ClienteEntity;
import com.example.taller2acm.persistence.repository.ClienteJpaRepository;
import com.example.taller2acm.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
@Validated
public class ClienteController {
    private final IClienteService service;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO dto) {
        ClienteEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.modelToDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.dtoFromModel(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
        ClienteEntity toUpdate = mapper.modelFromDto(dto);
        toUpdate.setId(id);
        ClienteEntity updated = service.save(toUpdate);
        return ResponseEntity.ok(mapper.dtoFromModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}