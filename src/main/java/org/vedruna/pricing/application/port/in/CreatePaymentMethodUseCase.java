package org.vedruna.pricing.application.port.in;

import org.vedruna.pricing.domain.model.PaymentMethod;

public interface CreatePaymentMethodUseCase {
    PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);
}
