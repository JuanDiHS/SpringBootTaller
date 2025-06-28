package com.example.taller2acm.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taller2acm.model.Reserva;
import com.example.taller2acm.persistence.repository.ReservaJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ReservaServiceImpl implements IReservaService {

    private final ReservaJpaRepository repository;
    private final ReservaMapper mapper;

    @Override
    public Reserva save(Reserva Model) {
        ReservaEntity entity = mapper.modelToEntity(Model);
        return mapper.entityToModel(repository.save(entity));
    }

    @Override
    public Reserva update(Reserva Model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Reserva findById(String id) {

        return repository.findAll().stream().map(mapper::entityToModel).toList();
        
    }

    @Override
    public List<Reserva> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Reserva> findByEmail(String email) {

        return repository.findByEmail(email).map(mapper::entityToModel)
        .or(Optional::empty; 

        );
    }

    @Override
    public ReservaEntity save(ReservaEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ReservaEntity update(ReservaEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<ReservaEntity> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<ReservaEntity> findByClienteId(Long clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByClienteId'");
    }

    @Override
    public List<ReservaEntity> findByHabitacionId(Long habitacionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByHabitacionId'");
    }

    @Override
    public List<ReservaEntity> findByFechaInicioBetween(LocalDateTime start, LocalDateTime end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByFechaInicioBetween'");
    }

    @Override
    public ReservaEntity save(ReservaEntity reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
