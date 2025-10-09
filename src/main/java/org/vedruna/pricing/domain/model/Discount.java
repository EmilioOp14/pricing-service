package org.vedruna.pricing.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    Integer id;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Float percentage;
    Price price;

}
