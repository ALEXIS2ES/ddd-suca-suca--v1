package com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.model.aggregates;

import com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.commands.AprovisinarSolicitudAlta;
import com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.events.SolicitudAltaAprovisionada;
import com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.model.valueobjects.EstadoAprovisionamientoSolicitud;
import jakarta.persistence.*;
import lombok.Getter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;

/**
 * Agregado raíz que representa una solicitud de aprovisionamiento
 * Implementa la persistencia JPA y el patrón CQRS con Axon Framework
 */
@Entity
@Table(name = "aprovisionamiento_solicitudes")
@Aggregate
@Getter
public class AprovisionamientoSolicitud {

    @Id
    @Column(name = "id")
    @AggregateIdentifier
    private String id;

    @Column(name = "solicitud_id", nullable = false)
    private String solicitudId;

    @Column(name = "trabajador_id", nullable = false)
    private String trabajadorId;

    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoAprovisionamientoSolicitud estado;

    @Column(name = "fecha_aprovisionamiento")
    private LocalDateTime fechaAprovisionamiento;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "prioridad")
    private String prioridad;

    @Version
    private Long version;

    /**
     * Constructor por defecto requerido por JPA
     */
    protected AprovisionamientoSolicitud() {
    }

    /**
     * Maneja el comando de creación de aprovisionamiento
     * @param command Comando con los datos del aprovisionamiento
     */
    @CommandHandler
    public AprovisionamientoSolicitud(AprovisinarSolicitudAlta command) {
        AggregateLifecycle.apply(new SolicitudAltaAprovisionada(
                command.getAprovisionamientoId(),
                command.getSolicitudId(),
                command.getTrabajadorId(),
                command.getTipoSolicitud(),
                EstadoAprovisionamientoSolicitud.PENDIENTE.toString(),
                LocalDateTime.now().toString(),
                command.getDepartamento(),
                command.getPrioridad()
        ));
    }

    /**
     * Maneja el evento de aprovisionamiento creado
     * @param event Evento con los datos del aprovisionamiento
     */
    @EventSourcingHandler
    public void on(SolicitudAltaAprovisionada event) {
        this.id = event.getAprovisionamientoId();
        this.solicitudId = event.getSolicitudId();
        this.trabajadorId = event.getTrabajadorId();
        this.tipoSolicitud = event.getTipoSolicitud();
        this.estado = EstadoAprovisionamientoSolicitud.valueOf(event.getEstado());
        this.fechaAprovisionamiento = LocalDateTime.parse(event.getFechaAprovisionamiento());
        this.departamento = event.getDepartamento();
        this.prioridad = event.getPrioridad();
    }

    /**
     * Actualiza el estado del aprovisionamiento
     * @param nuevoEstado Nuevo estado a establecer
     */
    public void actualizarEstado(EstadoAprovisionamientoSolicitud nuevoEstado) {
        this.estado = nuevoEstado;
        this.fechaAprovisionamiento = LocalDateTime.now();
    }
}