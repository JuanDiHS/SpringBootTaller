package com.example.taller2acm.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.TipoHabitacionEntity;

@Repository
public interface TipoHabitacionJpaRepository extends JpaRepository<TipoHabitacionEntity, Long> {
}
