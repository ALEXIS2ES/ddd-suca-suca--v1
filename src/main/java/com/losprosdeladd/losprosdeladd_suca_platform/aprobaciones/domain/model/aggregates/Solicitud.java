package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.model.aggregates;

import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.commands.AprobarAlta;
import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.events.SolicitudAltaAprobada;
import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.model.valueobjects.SolitudStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Solicitud {
    @AggregateIdentifier
    private Long id;
    private SolitudStatus solitudStatus;

    public Solicitud() {
    }

    @CommandHandler
    public Solicitud(AprobarAlta command) {
        SolicitudAltaAprobada event = new SolicitudAltaAprobada(
                command.getId(),
                command.getTrabajador_id(),
                command.getGestor_id(),
                command.getFechaCreacion(),
                command.getFechaAprobacion(),
                command.getFechaAtenccion()
        );
        apply(event);
    }
    @EventSourcingHandler
    protected void on(SolicitudAltaAprobada event) {
        id = event.getId();
        solitudStatus = SolitudStatus.APROBADO;
    }
}
