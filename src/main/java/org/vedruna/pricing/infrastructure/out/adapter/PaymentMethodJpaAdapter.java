package org.vedruna.pricing.infrastructure.out.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.exception.PaymentMethodNotFoundException;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.infrastructure.out.jpa.entity.PaymentMethodEntity;
import org.vedruna.pricing.infrastructure.out.jpa.mapper.PaymentMethodEntityMapper;
import org.vedruna.pricing.infrastructure.out.jpa.repository.PaymentMethodRepository;


@Component
@RequiredArgsConstructor
public class PaymentMethodJpaAdapter implements PaymentMethodRepositoryPort {

    private final PaymentMethodRepository repository;
    private final PaymentMethodEntityMapper mapper;

    @Override
    public Page<PaymentMethod> findAll(Pageable pageable) {
    return repository.findAll(pageable)
                     .map(mapper::toDomain);
    }

    @Override
    public PaymentMethod findById(Integer id) {
         return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new PaymentMethodNotFoundException(id));
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        PaymentMethodEntity entity = mapper.toEntity(paymentMethod);
        PaymentMethodEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }
}
