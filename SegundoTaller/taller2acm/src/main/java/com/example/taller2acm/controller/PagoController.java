package com.example.taller2acm.controller;


import com.example.taller2acm.dto.PagoDTO;
import com.example.taller2acm.model.Pago;
import com.example.taller2acm.service.IPagoService;
import com.example.taller2acm.util.PagoMapper;

import jakarta.validation.Valid;

import com.example.taller2acm.persistence.repository.PagoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;




@RestController
@RequestMapping("/api/v1/pago")
@RequiredArgsConstructor
@Validated
public class PagoController {
    private final IPagoService service;
    private final PagoMapper mapper;

    @PostMapping
    public ResponseEntity<PagoDTO> create(@Valid @RequestBody PagoDTO dto) {
        PagoEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.modelToDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> getAll() {
        List<PagoDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.dtoFromModel(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/reserva/{reservaId}")
    public ResponseEntity<List<PagoDTO>> getByReserva(@PathVariable Long reservaId) {
        List<PagoDTO> list = service.findByReservaId(reservaId).stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}