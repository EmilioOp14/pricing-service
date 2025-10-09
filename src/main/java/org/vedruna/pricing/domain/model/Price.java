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

    Discount discount;
    Float finalPrice;

    public Float getFinalPrice() {
    if (discount != null && discount.getPercentage() != null) {
        return price * (1 - discount.getPercentage() / 100);
    }
    return price;
}

}
