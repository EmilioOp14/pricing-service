package org.vedruna.pricing.domain.exception;

public class PaymentMethodNotFoundException extends RuntimeException {
    public PaymentMethodNotFoundException(Integer id) {
        super("PaymentMethod not found with id: " + id);
    }
}
