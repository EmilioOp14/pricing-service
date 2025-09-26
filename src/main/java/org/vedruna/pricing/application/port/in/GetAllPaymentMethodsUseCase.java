package org.vedruna.pricing.application.port.in;

import org.vedruna.pricing.domain.model.PaymentMethod;

import java.util.List;

public interface GetAllPaymentMethodsUseCase {
    List<PaymentMethod> getAllPaymentMethods();
}