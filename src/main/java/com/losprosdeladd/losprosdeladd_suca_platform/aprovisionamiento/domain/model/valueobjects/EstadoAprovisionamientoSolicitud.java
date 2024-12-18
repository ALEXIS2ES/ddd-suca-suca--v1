package com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.model.valueobjects;

/**
 * Enumeración que define los posibles estados de un aprovisionamiento
 * Cada estado tiene una descripción asociada
 */
public enum EstadoAprovisionamientoSolicitud {
    PENDIENTE("Pendiente de iniciar aprovisionamiento"),
    EN_PROCESO("Aprovisionamiento en proceso"),
    COMPLETADO("Aprovisionamiento completado exitosamente"),
    RECHAZADO("Aprovisionamiento rechazado"),
    CANCELADO("Aprovisionamiento cancelado"),
    EN_REVISION("Aprovisionamiento en revisión");

    private final String descripcion;

    /**
     * Constructor del enum
     */
    EstadoAprovisionamientoSolicitud(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del estado
     */
    public String getDescripcion() {
        return descripcion;
    }
}