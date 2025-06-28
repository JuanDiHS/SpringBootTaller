package com.example.taller2acm.controller;

import com.example.taller2acm.dto.ReservaDTO;
import com.example.taller2acm.model.Reserva;
import com.example.taller2acm.service.IReservaService;
import com.example.taller2acm.util.ReservaMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.example.taller2acm.persistence.repository.ReservaJpaRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/reserva")
@RequiredArgsConstructor
@Validated

public class ReservaController {

    private final IReservaService reservaService;
     private final ReservaMapper userMapper;


    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody ReservaDTO reservaDTO){


        Reserva created = reservaService.save(ReservaMapper.modelFromDto(reservaDTO));

        return ResponseEntity.ok(userMapper.dtoFromModel(created));

     @GetMapping
    public ResponseEntity<List<ReservaDTO>> getAll() {
        List<ReservaDTO> list = service.findAll().stream()
            .map(mapper::modelToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> ResponseEntity.ok(mapper.dtoFromModel(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @Valid @RequestBody ReservaDTO dto) {
        ReservaEntity toUpdate = mapper.modelFromDto(dto);
        toUpdate.setId(id);
        ReservaEntity updated = service.save(toUpdate);
        return ResponseEntity.ok(mapper.dtoFromModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }




    }

}
