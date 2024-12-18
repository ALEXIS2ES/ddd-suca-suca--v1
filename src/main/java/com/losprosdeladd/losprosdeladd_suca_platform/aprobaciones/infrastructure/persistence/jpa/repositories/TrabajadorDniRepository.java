package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.infrastructure.persistence.jpa.repositories;

import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.processors.TrabajadorDni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TrabajadorDniRepository extends JpaRepository<TrabajadorDni, Long> {
    Optional<TrabajadorDni> getByDni(String dni);

    @Query(value = "SELECT * FROM client_dnis WHERE id <> :id AND dni = :dni LIMIT 1", nativeQuery = true)
    Optional<TrabajadorDni> getByDniForDistinctId(String dni, Long id);
}
