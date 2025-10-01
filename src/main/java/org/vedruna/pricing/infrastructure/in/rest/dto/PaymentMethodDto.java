package org.vedruna.pricing.infrastructure.in.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentMethodDto(
        @NotNull(message = "El id no puede ser nulo")
        Integer id,

        @NotBlank(message = "El nombre del método de pago es obligatorio")
        String methodName
) {}
