package com.example.taller2acm.controller;

import com.example.taller2acm.dto.HabitacionDTO;
import com.example.taller2acm.model.Habitacion;
import com.example.taller2acm.service.IHabitacionService;
import com.example.taller2acm.util.HabitacionMapper;

import jakarta.validation.Valid;

import com.example.taller2acm.persistence.repository.HabitacionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/habitacion")
@RequiredArgsConstructor
@Validated
public class HabitacionController {
    private final IHabitacionService service;
    private final HabitacionMapper mapper;

    @PostMapping
    public ResponseEntity<HabitacionDTO> create(@Valid @RequestBody HabitacionDTO dto) {
        HabitacionEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.modelToDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<HabitacionDTO>> getAll() {
        List<HabitacionDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.dtoFromModel(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitacionDTO> update(@PathVariable Long id, @Valid @RequestBody HabitacionDTO dto) {
        HabitacionEntity toUpdate = mapper.modelFromDto(dto);
        toUpdate.setId(id);
        HabitacionEntity updated = service.save(toUpdate);
        return ResponseEntity.ok(mapper.dtoFromModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}