package com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.infrastructure.persistence.jpa.repositories;

import com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.model.aggregates.AprovisionamientoSolicitud;
import com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.model.valueobjects.EstadoAprovisionamientoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio JPA para la gestión de aprovisionamientos
 * Proporciona métodos para buscar y gestionar aprovisionamientos
 */
@Repository
public interface AprovisionamientoSolicitudRepository extends JpaRepository<AprovisionamientoSolicitud, String> {

    /**
     * Busca aprovisionamientos por ID de trabajador
     */
    List<AprovisionamientoSolicitud> findByTrabajadorId(String trabajadorId);

    /**
     * Busca aprovisionamientos por ID de solicitud
     */
    Optional<AprovisionamientoSolicitud> findBySolicitudId(String solicitudId);

    /**
     * Busca aprovisionamientos por estado
     */
    List<AprovisionamientoSolicitud> findByEstado(EstadoAprovisionamientoSolicitud estado);

    /**
     * Busca aprovisionamientos por departamento
     */
    List<AprovisionamientoSolicitud> findByDepartamento(String departamento);

    /**
     * Busca aprovisionamientos por rango de fechas
     */
    @Query("SELECT a FROM AprovisionamientoSolicitud a WHERE a.fechaAprovisionamiento BETWEEN ?1 AND ?2")
    List<AprovisionamientoSolicitud> findByRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Cuenta aprovisionamientos por estado
     */
    long countByEstado(EstadoAprovisionamientoSolicitud estado);
}