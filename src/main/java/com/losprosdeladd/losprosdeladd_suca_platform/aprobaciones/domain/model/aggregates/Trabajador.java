package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.model.aggregates;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Trabajador {
    @AggregateIdentifier
    protected Long id;
    //protected Rol rol;
}
