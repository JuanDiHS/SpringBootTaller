package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.repository.UsuarioJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioJpaRepository repo;

    @Override
    public List<UsuarioEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<UsuarioEntity> findByNombreUsuario(String nombreUsuario) {
        return repo.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public List<UsuarioEntity> findByRol(String rol) {
        return repo.findByRol(rol);
    }

    @Override
    public Optional<UsuarioEntity> findByClienteId(Long clienteId) {
        return repo.findByClienteId(clienteId);
    }

    @Override
    public Optional<UsuarioEntity> findByEmpleadoId(Long empleadoId) {
        return repo.findByEmpleadoId(empleadoId);
    }

    @Override
    public Optional<UsuarioEntity> findByAdministradorGeneralId(Long adminGeneralId) {
        return repo.findByAdministradorGeneralId(adminGeneralId);
    }

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return repo.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public UsuarioEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}