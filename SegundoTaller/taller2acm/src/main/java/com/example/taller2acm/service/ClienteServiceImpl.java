package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteJpaRepository repo;

    @Override
    public List<ClienteEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<ClienteEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<ClienteEntity> findByCedula(Integer cedula) {
        return repo.findByCedula(cedula);
    }

    @Override
    public List<ClienteEntity> findByPrimerApellido(String primerApellido) {
        return repo.findByPrimerApellido(primerApellido);
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return repo.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ClienteEntity update(ClienteEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ClienteEntity findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}