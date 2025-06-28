package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.entity.HotelEntity;
import com.example.taller2acm.persistence.repository.HotelJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private HotelJpaRepository repo;

    @Override
    public List<HotelEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<HotelEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<HotelEntity> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    @Override
    public List<HotelEntity> findByCiudad(String ciudad) {
        return repo.findByCiudad(ciudad);
    }

    @Override
    public HotelEntity save(HotelEntity hotel) {
        return repo.save(hotel);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public HotelEntity update(HotelEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public HotelEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public HotelEntity update(HotelEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public HotelEntity save(HotelEntity hotel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}