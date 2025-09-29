package org.vedruna.pricing.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vedruna.pricing.application.port.in.GetPaymentMethodByIdUseCase;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.model.PaymentMethod;

@Service
@RequiredArgsConstructor
public class GetPaymentMethodByIdService implements GetPaymentMethodByIdUseCase {

    private final PaymentMethodRepositoryPort repositoryPort;

    @Override
    public PaymentMethod getPaymentMethodById(Integer id) {
        return repositoryPort.findById(id);
    }
}
