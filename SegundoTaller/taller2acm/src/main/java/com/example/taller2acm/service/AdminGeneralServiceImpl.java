package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taller2acm.model.Reserva;
import com.example.taller2acm.persistence.entity.AdminGeneralEntity;
import com.example.taller2acm.persistence.entity.ReservaEntity;
import com.example.taller2acm.persistence.repository.AdminGeneralJpaRepository;
import com.example.taller2acm.util.AdminGeneralMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class AdminGeneralServiceImpl implements IAdminGeneralService {

    private final AdminGeneralJpaRepository repository;
    private final AdminGeneralMapper mapper;

    @Override
    public Reserva save(Reserva Model) {
        ReservaEntity entity = mapper.entityFromModel(Model);
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
    public AdminGeneralEntity save(AdminGeneralEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public AdminGeneralEntity update(AdminGeneralEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<AdminGeneralEntity> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Optional<AdminGeneralEntity> findByCorreo(String correo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCorreo'");
    }

    @Override
    public AdminGeneralEntity save(AdminGeneralEntity admin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public AdminGeneralEntity update(AdminGeneralEntity Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public AdminGeneralEntity save(AdminGeneralEntity admin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}

