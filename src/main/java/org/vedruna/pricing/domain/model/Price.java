package org.vedruna.pricing.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    Integer id;
    Integer coinsAmount;
    Float price;
    PaymentMethod paymentMethod;

}
