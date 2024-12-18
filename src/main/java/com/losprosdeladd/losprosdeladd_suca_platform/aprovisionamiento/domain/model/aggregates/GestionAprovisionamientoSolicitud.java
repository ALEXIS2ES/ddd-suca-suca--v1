package com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.model.aggregates;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad que gestiona los detalles adicionales del aprovisionamiento
 * Mantiene información complementaria no manejada por el agregado principal
 */
@Entity
@Table(name = "gestion_aprovisionamiento_solicitud")
@Getter
@Setter
public class GestionAprovisionamientoSolicitud {
    @Id
    private String aprovisionamientoId;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estado_detallado")
    private String estadoDetallado;

    /**
     * Constructor por defecto requerido por JPA
     */
    protected GestionAprovisionamientoSolicitud() {}

    /**
     * Constructor principal para crear una nueva gestión
     */
    public GestionAprovisionamientoSolicitud(String aprovisionamientoId,
                                             String responsable) {
        this.aprovisionamientoId = aprovisionamientoId;
        this.responsable = responsable;
        this.fechaInicio = LocalDateTime.now();
        this.estadoDetallado = "INICIADO";
    }

    /**
     * Método para finalizar la gestión
     */
    public void finalizarGestion(String observaciones) {
        this.fechaFin = LocalDateTime.now();
        this.observaciones = observaciones;
        this.estadoDetallado = "FINALIZADO";
    }
}