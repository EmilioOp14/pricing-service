package org.vedruna.pricing.domain.model;


public class Price {

    private final Integer id;
    private final Integer coinsAmount;
    private final Float price;
    private final PaymentMethod paymentMethod;

        public Price(Integer id, Integer coinsAmount, Float price, PaymentMethod paymentMethod) {
        this.id = id;
        this.coinsAmount = coinsAmount;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public Integer getId() { return id; }
    public Integer getCoinsAmount() { return coinsAmount; }
    public Float getPrice(){ return price; }
    public PaymentMethod getPaymentMethod() { return paymentMethod; }


}
