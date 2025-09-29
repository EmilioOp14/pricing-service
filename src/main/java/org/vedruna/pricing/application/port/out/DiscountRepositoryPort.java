package org.vedruna.pricing.application.port.out;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.domain.model.Discount;

public interface DiscountRepositoryPort {
    Page<Discount> findAll(Pageable pageable);
}
