package org.vedruna.pricing.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vedruna.pricing.application.port.in.GetAllPaymentMethodsUseCase;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.model.PaymentMethod;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllPaymentMethodsService implements GetAllPaymentMethodsUseCase {

    private final PaymentMethodRepositoryPort repositoryPort;

    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return repositoryPort.findAll();
    }
}
