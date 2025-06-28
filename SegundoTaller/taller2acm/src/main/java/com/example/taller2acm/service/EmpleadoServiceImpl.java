package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.entity.EmpleadoEntity;
import com.example.taller2acm.persistence.repository.EmpleadoJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private EmpleadoJpaRepository repo;

    @Override
    public List<EmpleadoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<EmpleadoEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<EmpleadoEntity> findByCorreo(String correo) {
        return repo.findByCorreo(correo);
    }

    @Override
    public Optional<EmpleadoEntity> findByTelefono(String telefono) {
        return repo.findByTelefono(telefono);
    }

    @Override
    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return repo.save(empleado);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public EmpleadoEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public EmpleadoEntity save(EmpleadoEntity empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
