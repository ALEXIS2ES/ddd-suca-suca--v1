package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.processors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class TrabajadorDni {
    @Id
    public Long id;

    @Column(length=8, unique = true)
    public String dni;

    public TrabajadorDni() {
    }

    public TrabajadorDni(Long id, String dni) {
        this.id = id;
        this.dni = dni;
    }
}
