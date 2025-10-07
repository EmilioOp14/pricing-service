package org.vedruna.pricing.infrastructure.adapters.out.persistance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.out.PriceJpaRepository;
import org.vedruna.pricing.infrastructure.adapters.out.converter.OutBoundConverter;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.repository.PriceRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JpaRepositoryImpl implements PriceJpaRepository{

    OutBoundConverter converter;
    PriceRepository repository;

    @Override
    public Page<Price> getAllPrices(Pageable pageable) {
        return repository.findAll(pageable)
                .map(converter::toDomain);
    }

    @Override
    public Price getAPriceById(Integer id) {
        return converter.toDomain(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price with id " + id + " not found")));
    }

}
