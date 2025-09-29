package org.vedruna.pricing.infrastructure.out.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.application.port.out.PriceRepositoryPort;
import org.vedruna.pricing.domain.exception.PriceNotFoundException;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.infrastructure.out.jpa.mapper.PriceEntityMapper;
import org.vedruna.pricing.infrastructure.out.jpa.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceJpaAdapter implements PriceRepositoryPort {
    
 private final PriceRepository repository;
    private final PriceEntityMapper mapper;

    @Override
    public Page<Price> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Price findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new PriceNotFoundException(id));
    }
    
}
