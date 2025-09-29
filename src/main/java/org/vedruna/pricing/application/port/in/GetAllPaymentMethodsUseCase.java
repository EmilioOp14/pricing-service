package org.vedruna.pricing.application.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.domain.model.PaymentMethod;


public interface GetAllPaymentMethodsUseCase {
    Page<PaymentMethod> getAllPaymentMethods(Pageable pageable);
}