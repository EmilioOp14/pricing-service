package org.vedruna.pricing.domain.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.domain.model.Price;

public interface PriceJpaRepository {
     Page<Price> getAllPrices(Pageable pageable);
     Price getAPriceById(Integer id);
}
