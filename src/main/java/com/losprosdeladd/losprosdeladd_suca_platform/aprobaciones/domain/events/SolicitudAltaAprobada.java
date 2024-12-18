package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.events;

import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.model.valueobjects.SolitudStatus;
import lombok.Value;
import java.time.LocalDateTime;

@Value
public class SolicitudAltaAprobada {
    private Long id;
    private String trabajador_id;
    private String gestor_id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaAprobacion;
    private LocalDateTime fechaAtenccion;
}
