package com.example.taller2acm.controller;

import com.example.taller2acm.dto.AdminGeneralDTO;
import com.example.taller2acm.model.AdminGeneral;
import com.example.taller2acm.service.IAdminGeneralService;
import com.example.taller2acm.util.AdminGeneralMapper;
import com.example.taller2acm.persistence.repository.AdminGeneralJpaRepository;
import com.example.taller2acm.persistence.entity.AdminGeneralEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/v1/admin-general")
@RequiredArgsConstructor
@Validated
public class AdminGeneralController {
    private final IAdminGeneralService service;
    private final AdminGeneralMapper mapper;

    @PostMapping
    public ResponseEntity<AdminGeneralDTO> create(@Valid @RequestBody AdminGeneralDTO dto) {
        AdminGeneralEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.dtoFromModel(saved));
    }

    @GetMapping
    public ResponseEntity<List<AdminGeneralDTO>> getAll() {
        List<AdminGeneralDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminGeneralDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.modelToDto(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminGeneralDTO> update(@PathVariable Long id, @Valid @RequestBody AdminGeneralDTO dto) {
        AdminGeneralEntity toUpdate = mapper.modelFromDto(dto);
        toUpdate.setId(id);
        AdminGeneralEntity updated = service.save(toUpdate);
        return ResponseEntity.ok(mapper.dtoFromModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
