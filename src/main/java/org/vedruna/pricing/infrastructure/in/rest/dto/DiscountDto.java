package org.vedruna.pricing.infrastructure.in.rest.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record DiscountDto(
        @NotNull(message = "El id no puede ser nulo")
        Integer id,

        @NotNull(message = "La fecha de inicio no puede ser nula")
        LocalDateTime startDate,

        @NotNull(message = "La fecha de fin no puede ser nula")
        @Future(message = "La fecha de fin debe estar en el futuro")
        LocalDateTime endDate,

        @NotNull(message = "El porcentaje de descuento no puede ser nulo")
        @Positive(message = "El descuento debe ser mayor que 0")
        Float discount,

        @NotNull(message = "El precio es obligatorio")
        PriceDto price
) {}
