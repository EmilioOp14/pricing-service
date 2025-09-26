package org.vedruna.pricing.infrastructure.out.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.infrastructure.out.jpa.mapper.PaymentMethodEntityMapper;
import org.vedruna.pricing.infrastructure.out.jpa.repository.PaymentMethodRepository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentMethodJpaAdapter implements PaymentMethodRepositoryPort {

    private final PaymentMethodRepository repository;
    private final PaymentMethodEntityMapper mapper;

    @Override
    public List<PaymentMethod> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<PaymentMethod> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }
}
