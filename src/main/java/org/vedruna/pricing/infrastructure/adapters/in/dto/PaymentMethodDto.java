package org.vedruna.pricing.infrastructure.adapters.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentMethodDto {
        @NotNull(message = "Id cannot be null")
        Integer id;

        @NotBlank(message = "Payment method name is required")
        String methodName;
}
