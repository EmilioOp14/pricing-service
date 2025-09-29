package org.vedruna.pricing.infrastructure.in.rest.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDto {
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Float discount;
    private PriceDto price;
}
