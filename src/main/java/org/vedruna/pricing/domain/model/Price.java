package org.vedruna.pricing.domain.model;


import lombok.Data;

@Data
public class Price {

    Integer id;
    Integer coinsAmount;
    Float price;
    PaymentMethod paymentMethod;

}
