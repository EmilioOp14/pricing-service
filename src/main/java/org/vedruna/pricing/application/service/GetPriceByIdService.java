package org.vedruna.pricing.application.service;

import org.springframework.stereotype.Service;
import org.vedruna.pricing.application.port.in.GetPriceByIdUseCase;
import org.vedruna.pricing.application.port.out.PriceRepositoryPort;
import org.vedruna.pricing.domain.model.Price;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPriceByIdService implements GetPriceByIdUseCase{

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Price getPriceById(Integer id) {
        return priceRepositoryPort.findById(id);
    }
    
}
