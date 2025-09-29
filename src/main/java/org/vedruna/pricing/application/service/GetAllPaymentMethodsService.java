package org.vedruna.pricing.application.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vedruna.pricing.application.port.in.GetAllPaymentMethodsUseCase;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.model.PaymentMethod;


@Service
@RequiredArgsConstructor
public class GetAllPaymentMethodsService implements GetAllPaymentMethodsUseCase {

    private final PaymentMethodRepositoryPort repositoryPort;

    @Override
    public Page<PaymentMethod> getAllPaymentMethods(Pageable pageable) {
        return repositoryPort.findAll(pageable);
    }
}
