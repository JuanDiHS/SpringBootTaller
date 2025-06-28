package com.example.taller2acm.controller;



import com.example.taller2acm.dto.EmpleadoDTO;
import com.example.taller2acm.model.Empleado;
import com.example.taller2acm.service.IEmpleadoService;
import com.example.taller2acm.util.EmpleadoMapper;

import jakarta.validation.Valid;

import com.example.taller2acm.persistence.repository.EmpleadoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/empleado")
@RequiredArgsConstructor
@Validated
public class EmpleadoController {
    private final IEmpleadoService service;
    private final EmpleadoMapper mapper;

    @PostMapping
    public ResponseEntity<EmpleadoDTO> create(@Valid @RequestBody EmpleadoDTO dto) {
        EmpleadoEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.modelToDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAll() {
        List<EmpleadoDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.dtoFromModel(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable Long id, @Valid @RequestBody EmpleadoDTO dto) {
        EmpleadoEntity toUpdate = mapper.modelFromDto(dto);
        toUpdate.setId(id);
        EmpleadoEntity updated = service.save(toUpdate);
        return ResponseEntity.ok(mapper.dtoFromModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
