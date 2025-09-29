package org.vedruna.pricing.application.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.domain.model.Price;

public interface PriceRepositoryPort {
     Page<Price> findAll(Pageable pageable);
     Price findById(Integer id);
}
