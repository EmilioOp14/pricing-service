package org.vedruna.pricing.domain.port.in;

import org.vedruna.pricing.domain.model.Price;

public interface GetAPriceByIdUseCase {
    Price getAPrice(Integer id);
}
