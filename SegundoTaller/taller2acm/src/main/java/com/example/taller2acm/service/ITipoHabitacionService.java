package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

public interface ITipoHabitacionService extends BaseService<TipoHabitacionEntity>{
    List<TipoHabitacionEntity> findAll();
    Optional<TipoHabitacionEntity> findById(Long id);
    Optional<TipoHabitacionEntity> findByNombre(String nombre);
    List<TipoHabitacionEntity> findByHotelId(Long hotelId);
    TipoHabitacionEntity save(TipoHabitacionEntity tipo);
    void deleteById(Long id);
}