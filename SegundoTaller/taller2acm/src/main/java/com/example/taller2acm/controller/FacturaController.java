package com.example.taller2acm.controller;

import com.example.taller2acm.dto.FacturaDTO;
import com.example.taller2acm.model.Factura;
import com.example.taller2acm.service.IFacturaService;
import com.example.taller2acm.util.FacturaMapper;
import com.example.taller2acm.persistence.repository.FacturaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/factura")
@RequiredArgsConstructor
@Validated
public class FacturaController {
    private final IFacturaService service;
    private final FacturaMapper mapper;

    @PostMapping
    public ResponseEntity<FacturaDTO> create(@Valid @RequestBody FacturaDTO dto) {
        FacturaEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.modelToDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> getAll() {
        List<FacturaDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/reserva/{reservaId}")
    public ResponseEntity<List<FacturaDTO>> getByReserva(@PathVariable Long reservaId) {
        List<FacturaDTO> list = service.findByReservaId(reservaId).stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.dtoFromModel(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}