package org.vedruna.pricing.application.port.out;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.domain.model.PaymentMethod;

public interface PaymentMethodRepositoryPort {
    Page<PaymentMethod> findAll(Pageable pageable);
    PaymentMethod findById(Integer id);
    PaymentMethod save(PaymentMethod paymentMethod);
}
