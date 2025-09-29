package org.vedruna.pricing.application.port.in;

import org.vedruna.pricing.domain.model.Price;

public interface GetPriceByIdUseCase {
     Price getPriceById(Integer id);
}
