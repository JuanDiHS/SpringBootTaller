package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService extends BaseService<UsuarioEntity>{
    List<UsuarioEntity> findAll();
    Optional<UsuarioEntity> findById(Long id);
    Optional<UsuarioEntity> findByNombreUsuario(String nombreUsuario);
    List<UsuarioEntity> findByRol(String rol);
    Optional<UsuarioEntity> findByClienteId(Long clienteId);
    Optional<UsuarioEntity> findByEmpleadoId(Long empleadoId);
    Optional<UsuarioEntity> findByAdministradorGeneralId(Long adminGeneralId);
    UsuarioEntity save(UsuarioEntity usuario);
    void deleteById(Long id);
}