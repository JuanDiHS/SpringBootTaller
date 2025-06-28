package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.repository.PagoJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private PagoJpaRepository repo;

    @Override
    public List<PagoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<PagoEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<PagoEntity> findByReservaId(Long reservaId) {
        return repo.findByReservaId(reservaId);
    }

    @Override
    public List<PagoEntity> findByMetodoPago(String metodoPago) {
        return repo.findByMetodoPago(metodoPago);
    }

    @Override
    public PagoEntity save(PagoEntity pago) {
        return repo.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public PagoEntity update(PagoEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public PagoEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}