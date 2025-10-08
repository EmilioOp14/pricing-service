package org.vedruna.pricing.infrastructure.adapters.out.persistance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.out.PriceJpaRepository;
import org.vedruna.pricing.infrastructure.adapters.out.converter.OutBoundConverter;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.repository.PriceRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class JpaRepositoryImpl implements PriceJpaRepository{

    OutBoundConverter converter;
    PriceRepository repository;

    @Override
    public Page<Price> getAllPrices(Pageable pageable) {
        log.debug("Checking all prices in database (page={}, size={}, sort={})", pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        Page<Price> prices = repository.findAll(pageable).map(converter::toDomain);
        log.info("Database returned {} prices", prices.getTotalElements());
        return prices;
    }

    @Override
    public Price getAPriceById(Integer id) {
        log.debug("Checking price with id {} in database", id);
        return repository.findById(id)
                .map(converter::toDomain)
                .orElseThrow(() -> {
                    log.error("Price with id {} not found", id);
                    return new RuntimeException("Price with id " + id + " not found");
                });
    }

}
