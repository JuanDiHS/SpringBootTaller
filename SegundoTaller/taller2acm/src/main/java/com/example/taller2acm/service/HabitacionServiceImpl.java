package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.entity.HabitacionEntity;
import com.example.taller2acm.persistence.repository.HabitacionJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class HabitacionServiceImpl implements IHabitacionService {

    @Autowired
    private HabitacionJpaRepository repo;

    @Override
    public List<HabitacionEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<HabitacionEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<HabitacionEntity> findByNumeroHabitacion(Integer numeroHabitacion) {
        return repo.findByNumeroHabitacion(numeroHabitacion);
    }

    @Override
    public List<HabitacionEntity> findByHotelId(Long hotelId) {
        return repo.findByHotelId(hotelId);
    }

    @Override
    public List<HabitacionEntity> findByTipoHabitacionId(Long tipoHabitacionId) {
        return repo.findByTipoHabitacionId(tipoHabitacionId);
    }

    @Override
    public HabitacionEntity save(HabitacionEntity habitacion) {
        return repo.save(habitacion);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public HabitacionEntity update(HabitacionEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public HabitacionEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public HabitacionEntity update(HabitacionEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public HabitacionEntity save(HabitacionEntity habitacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}