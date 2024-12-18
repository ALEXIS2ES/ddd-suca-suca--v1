package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.commands;

import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.model.valueobjects.SolitudStatus;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.time.LocalDateTime;

@Value
public class AprobarAlta {
    @TargetAggregateIdentifier
    private Long id;
    private String trabajador_id;
    private String gestor_id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaAprobacion;
    private LocalDateTime fechaAtenccion;
}
