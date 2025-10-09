package org.vedruna.pricing.infrastructure.adapters.in.dto;

import org.vedruna.pricing.domain.model.PaymentMethod;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
        @NotNull(message = "Id cannot be null")
        Integer id;

        @NotNull(message = "Coin amount cannot be null")
        @Positive(message = "Coin amount must be positive")
        Integer coinsAmount;

        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price must be positive")
        Float price;

        @NotNull(message = "Payment method is required")
        PaymentMethod paymentMethod;

        Float discountPercentage;
        Float finalPrice;   
}
