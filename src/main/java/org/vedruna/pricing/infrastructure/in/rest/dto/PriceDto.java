package org.vedruna.pricing.infrastructure.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {
    private Integer id;
    private Integer coinsAmount;
    private Float price;
    private PaymentMethodDto paymentMethod;
}
