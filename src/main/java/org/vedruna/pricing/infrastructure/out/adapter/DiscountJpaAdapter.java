package org.vedruna.pricing.infrastructure.out.adapter;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.application.port.out.DiscountRepositoryPort;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.infrastructure.out.jpa.mapper.DiscountEntityMapper;
import org.vedruna.pricing.infrastructure.out.jpa.repository.DiscountRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DiscountJpaAdapter implements DiscountRepositoryPort{

    private final DiscountRepository repository;
    private final DiscountEntityMapper mapper;
    @Override
    public Page<Discount> findAll(Pageable pageable) {
    return repository.findAll(pageable)
                     .map(mapper::toDomain);
    }
 


    
}
