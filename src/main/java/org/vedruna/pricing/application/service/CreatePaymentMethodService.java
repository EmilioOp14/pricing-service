package org.vedruna.pricing.application.service;

import org.springframework.stereotype.Service;
import org.vedruna.pricing.application.port.in.CreatePaymentMethodUseCase;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.model.PaymentMethod;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreatePaymentMethodService implements CreatePaymentMethodUseCase {

    private final PaymentMethodRepositoryPort paymentMethodRepositoryPort;

    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepositoryPort.save(paymentMethod);
    }
    
}
