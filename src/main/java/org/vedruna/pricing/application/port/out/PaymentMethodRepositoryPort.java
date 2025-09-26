package org.vedruna.pricing.application.port.out;

import java.util.List;
import java.util.Optional;

import org.vedruna.pricing.domain.model.PaymentMethod;

public interface PaymentMethodRepositoryPort {
    List<PaymentMethod> findAll();
    Optional<PaymentMethod> findById(Integer id);
}
