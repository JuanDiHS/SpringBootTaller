package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.repository.TipoHabitacionJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class TipoHabitacionServiceImpl implements ITipoHabitacionService {

    @Autowired
    private TipoHabitacionJpaRepository repo;

    @Override
    public List<TipoHabitacionEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoHabitacionEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<TipoHabitacionEntity> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    @Override
    public List<TipoHabitacionEntity> findByHotelId(Long hotelId) {
        return repo.findByHotelId(hotelId);
    }

    @Override
    public TipoHabitacionEntity save(TipoHabitacionEntity tipo) {
        return repo.save(tipo);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public TipoHabitacionEntity update(TipoHabitacionEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public TipoHabitacionEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}