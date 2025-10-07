package org.vedruna.pricing.application.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.in.GetAllPricesUseCase;
import org.vedruna.pricing.domain.port.out.PriceJpaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAllPricesImpl implements GetAllPricesUseCase {

    PriceJpaRepository priceRepository;

    @Override
    public Page<Price> getAllPrices(Pageable pageable) {
        return priceRepository.getAllPrices(pageable);
    }

}
