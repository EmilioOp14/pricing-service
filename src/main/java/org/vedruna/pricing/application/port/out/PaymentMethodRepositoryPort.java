package org.vedruna.pricing.application.port.out;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.domain.model.PaymentMethod;

public interface PaymentMethodRepositoryPort {
    Page<PaymentMethod> findAll(Pageable pageable);
    Optional<PaymentMethod> findById(Integer id);
}
