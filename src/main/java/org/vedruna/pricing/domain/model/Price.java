package org.vedruna.pricing.domain.model;


public class Price {

    private final Integer id;
    private final Integer amount;
    private final Float price;
    private final PaymentMethod paymentMethod;

        public Price(Integer id, Integer amount, Float price, PaymentMethod paymentMethod) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public Integer getId() { return id; }
    public Integer getAmount() { return amount; }
    public Float getPrice(){ return price; }
    public PaymentMethod getPaymentMethod() { return paymentMethod; }


}
