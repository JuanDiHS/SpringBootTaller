
package com.example.taller2acm.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.EmpleadoEntity;


@Repository
public interface EmpleadoJpaRepository extends JpaRepository<EmpleadoEntity, Long> {
    
}
