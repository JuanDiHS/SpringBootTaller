package com.example.taller2acm.controller;

import com.example.taller2acm.dto.HotelDTO;
import com.example.taller2acm.model.Hotel;
import com.example.taller2acm.service.IHotelService;
import com.example.taller2acm.util.HotelMapper;

import jakarta.validation.Valid;

import com.example.taller2acm.persistence.entity.HotelEntity;
import com.example.taller2acm.persistence.repository.HotelJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
@Validated
public class HotelController {
    private final IHotelService service;
    private final HotelMapper mapper;

    @PostMapping
    public ResponseEntity<HotelDTO> create(@Valid @RequestBody HotelDTO dto) {
        HotelEntity saved = service.save(mapper.modelFromDto(dto));
        return ResponseEntity.ok(mapper.modelToDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAll() {
        List<HotelDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.dtoFromModel(entity)));
    }
}
