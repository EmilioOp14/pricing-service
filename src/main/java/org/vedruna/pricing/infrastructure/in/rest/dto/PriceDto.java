package org.vedruna.pricing.infrastructure.in.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PriceDto(
        @NotNull(message = "El id no puede ser nulo")
        Integer id,

        @NotNull(message = "La cantidad de monedas no puede ser nula")
        @Positive(message = "La cantidad de monedas debe ser positiva")
        Integer coinsAmount,

        @NotNull(message = "El precio no puede ser nulo")
        @Positive(message = "El precio debe ser positivo")
        Float price,

        @NotNull(message = "El método de pago es obligatorio")
        PaymentMethodDto paymentMethod
) {}
