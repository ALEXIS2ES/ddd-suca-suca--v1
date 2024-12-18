package com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.application.validators;

import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.commands.AprobarAlta;
import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.domain.processors.TrabajadorDni;
import com.losprosdeladd.losprosdeladd_suca_platform.aprobaciones.infrastructure.persistence.jpa.repositories.TrabajadorDniRepository;
import com.losprosdeladd.losprosdeladd_suca_platform.shared.domain.model.valueobjects.Notification;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AprobarAltaValidator {
    private final TrabajadorDniRepository trabajadorDniRepository;
    private static final int DNI_MAX_LENGTH = 8;

    public AprobarAltaValidator(TrabajadorDniRepository clientDniRepository) {
        this.trabajadorDniRepository = clientDniRepository;
    }

    public Notification validate(AprobarAlta command)
    {
        Notification notification = new Notification();

        String firstName = command.getTrabajador_id().trim();
        if (firstName.isEmpty()) notification.addError("El id del trabjador es obligatorio");

        String lastName = command.getGestor_id();
        if (lastName.isEmpty()) notification.addError("el id del Gestor es obligatorio");

        if (notification.hasErrors()) return notification;

        return notification;
    }
}
