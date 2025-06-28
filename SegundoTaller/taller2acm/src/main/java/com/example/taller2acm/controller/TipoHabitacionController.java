package com.example.taller2acm.controller;


import com.example.taller2acm.dto.TipoHabitacionDTO;
import com.example.taller2acm.model.TipoHabitacion;
import com.example.taller2acm.service.ITipoHabitacionService;
import com.example.taller2acm.util.TipoHabitacionMapper;

import jakarta.validation.Valid;

import com.example.taller2acm.persistence.entity.TipoHabitacionEntity;
import com.example.taller2acm.persistence.repository.TipoHabitacionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/tipo-habitacion")
@RequiredArgsConstructor
@Validated
public class TipoHabitacionController {
    private final ITipoHabitacionService service;
    private final TipoHabitacionMapper mapper;

    @PostMapping
    public ResponseEntity<TipoHabitacionDTO> create(@Valid @RequestBody TipoHabitacionDTO dto) {
        TipoHabitacionEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.dtoFromModel(saved));
    }

    @GetMapping
    public ResponseEntity<List<TipoHabitacionDTO>> getAll() {
        List<TipoHabitacionDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacionDTO> getById(@PathVariable Long id) {
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