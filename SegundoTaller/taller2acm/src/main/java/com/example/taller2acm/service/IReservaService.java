package com.example.taller2acm.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IReservaService extends BaseService<ReservaEntity>{

     List<ReservaEntity> findAll();
    Optional<ReservaEntity> findById(Long id);
    // Ejemplo de método de búsqueda por email, si aplica en tu lógica de negocio
    Optional<ReservaEntity> findByEmail(String email);
    List<ReservaEntity> findByClienteId(Long clienteId);
    List<ReservaEntity> findByHabitacionId(Long habitacionId);
    List<ReservaEntity> findByFechaInicioBetween(LocalDateTime start, LocalDateTime end);
    ReservaEntity save(ReservaEntity reserva);
    void deleteById(Long id);

}
