package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.repository.FacturaJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    private FacturaJpaRepository repo;

    @Override
    public List<FacturaEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<FacturaEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<FacturaEntity> findByReservaId(Long reservaId) {
        return repo.findByReservaId(reservaId);
    }

    @Override
    public List<FacturaEntity> findByPagoId(Long pagoId) {
        return repo.findByPagoId(pagoId);
    }

    @Override
    public FacturaEntity save(FacturaEntity factura) {
        return repo.save(factura);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public FacturaEntity update(FacturaEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public FacturaEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}