package com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.events;

import lombok.Value;

/**
 * Evento que se emite cuando una solicitud de alta ha sido aprovisionada
 * Contiene toda la información del aprovisionamiento realizado
 */
@Value
public class SolicitudAltaAprovisionada {
    private final String aprovisionamientoId;    // ID del aprovisionamiento
    private final String solicitudId;            // ID de la solicitud
    private final String trabajadorId;           // ID del trabajador
    private final String tipoSolicitud;          // Tipo de solicitud
    private final String estado;                 // Estado del aprovisionamiento
    private final String fechaAprovisionamiento; // Fecha del aprovisionamiento
    private final String departamento;           // Departamento
    private final String prioridad;              // Prioridad

    /**
     * Constructor que inicializa todos los campos del evento
     */
    public SolicitudAltaAprovisionada(String aprovisionamientoId,
                                      String solicitudId,
                                      String trabajadorId,
                                      String tipoSolicitud,
                                      String estado,
                                      String fechaAprovisionamiento,
                                      String departamento,
                                      String prioridad) {
        this.aprovisionamientoId = aprovisionamientoId;
        this.solicitudId = solicitudId;
        this.trabajadorId = trabajadorId;
        this.tipoSolicitud = tipoSolicitud;
        this.estado = estado;
        this.fechaAprovisionamiento = fechaAprovisionamiento;
        this.departamento = departamento;
        this.prioridad = prioridad;
    }
}