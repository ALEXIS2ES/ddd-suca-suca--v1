package com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Comando para iniciar el proceso de aprovisionamiento de una solicitud de alta
 * Este comando es inmutable y contiene toda la información necesaria para el aprovisionamiento
 */
@Value
public class AprovisinarSolicitudAlta {
    @TargetAggregateIdentifier
    private final String aprovisionamientoId;    // ID único del aprovisionamiento
    private final String solicitudId;            // ID de la solicitud relacionada
    private final String trabajadorId;           // ID del trabajador
    private final String tipoSolicitud;          // Tipo de solicitud
    private final String fechaSolicitud;         // Fecha de la solicitud
    private final String departamento;           // Departamento del trabajador
    private final String prioridad;              // Prioridad de la solicitud

    /**
     * Constructor que inicializa todos los campos necesarios
     */
    public AprovisinarSolicitudAlta(String aprovisionamientoId,
                                    String solicitudId,
                                    String trabajadorId,
                                    String tipoSolicitud,
                                    String fechaSolicitud,
                                    String departamento,
                                    String prioridad) {
        this.aprovisionamientoId = aprovisionamientoId;
        this.solicitudId = solicitudId;
        this.trabajadorId = trabajadorId;
        this.tipoSolicitud = tipoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.departamento = departamento;
        this.prioridad = prioridad;
    }
}