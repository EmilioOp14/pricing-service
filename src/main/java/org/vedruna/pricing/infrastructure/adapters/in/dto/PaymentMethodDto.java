package org.vedruna.pricing.infrastructure.adapters.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentMethodDto {
        @NotNull(message = "El id no puede ser nulo")
        Integer id;

        @NotBlank(message = "El nombre del método de pago es obligatorio")
        String methodName;
}
