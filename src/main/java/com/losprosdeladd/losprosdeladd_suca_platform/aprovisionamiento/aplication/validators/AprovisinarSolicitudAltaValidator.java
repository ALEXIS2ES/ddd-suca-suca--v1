package com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.aplication.validators;

import com.losprosdeladd.losprosdeladd_suca_platform.aprovisionamiento.domain.commands.AprovisinarSolicitudAlta;
import com.losprosdeladd.losprosdeladd_suca_platform.shared.domain.model.valueobjects.Notification;
import org.springframework.stereotype.Component;

/**
 * Validador para el comando de aprovisionamiento de solicitud de alta
 * Se encarga de validar todos los campos necesarios antes de procesar el comando
 */
@Component
public class AprovisinarSolicitudAltaValidator {

    /**
     * Realiza la validación del comando AprovisinarSolicitudAlta
     * @param command Comando a validar
     * @return Notification con los errores encontrados, si los hay
     */
    public Notification validate(AprovisinarSolicitudAlta command) {
        Notification notification = new Notification();

        // Validación del ID de aprovisionamiento
        if (isNullOrEmpty(command.getAprovisionamientoId())) {
            notification.addError("El ID de aprovisionamiento es requerido");
        }

        // Validación del ID de solicitud
        if (isNullOrEmpty(command.getSolicitudId())) {
            notification.addError("El ID de solicitud es requerido");
        }

        // Validación del ID del trabajador
        if (isNullOrEmpty(command.getTrabajadorId())) {
            notification.addError("El ID del trabajador es requerido");
        }

        // Validación del tipo de solicitud
        if (isNullOrEmpty(command.getTipoSolicitud())) {
            notification.addError("El tipo de solicitud es requerido");
        }

        // Validación de la fecha de solicitud
        if (isNullOrEmpty(command.getFechaSolicitud())) {
            notification.addError("La fecha de solicitud es requerida");
        }

        return notification;
    }

    /**
     * Verifica si una cadena es nula o está vacía
     * @param value Cadena a verificar
     * @return true si la cadena es nula o está vacía
     */
    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}