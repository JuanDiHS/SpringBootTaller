package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.EmpleadoEntity;

public interface IEmpleadoService extends BaseService<EmpleadoEntity>{
    List<EmpleadoEntity> findAll();
    Optional<EmpleadoEntity> findById(Long id);
    Optional<EmpleadoEntity> findByCorreo(String correo);
    Optional<EmpleadoEntity> findByTelefono(String telefono);
    EmpleadoEntity save(EmpleadoEntity empleado);
    void deleteById(Long id);
}