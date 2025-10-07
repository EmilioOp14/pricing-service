package org.vedruna.pricing.application.usecase;

import org.springframework.stereotype.Component;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.in.GetAPriceByIdUseCase;
import org.vedruna.pricing.domain.port.out.PriceJpaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAPriceByIdImpl implements GetAPriceByIdUseCase{

    PriceJpaRepository priceRepository;

    @Override
    public Price getAPrice(Integer id) {
        return priceRepository.getAPriceById(id);
    }
    
}
