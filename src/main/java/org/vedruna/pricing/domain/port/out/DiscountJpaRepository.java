package org.vedruna.pricing.domain.port.out;

import java.time.LocalDateTime;

import org.vedruna.pricing.domain.model.Discount;

public interface DiscountJpaRepository {
    Discount findActiveDiscountForPrice(Integer priceId, LocalDateTime now);
}
