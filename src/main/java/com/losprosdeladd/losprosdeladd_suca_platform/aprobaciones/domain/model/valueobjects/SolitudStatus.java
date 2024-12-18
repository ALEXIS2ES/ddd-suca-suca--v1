package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.model.valueobjects;

public enum SolitudStatus {
    APROVISIONADO (3),
    RECHAZADO (2),
    APROBADO (1),
    PENDIENTE(0);

    private int id;

    SolitudStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}