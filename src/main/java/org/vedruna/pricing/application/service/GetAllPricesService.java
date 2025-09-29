package org.vedruna.pricing.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vedruna.pricing.application.port.in.GetAllPricesUseCase;
import org.vedruna.pricing.application.port.out.PriceRepositoryPort;
import org.vedruna.pricing.domain.model.Price;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAllPricesService implements GetAllPricesUseCase{

    private final PriceRepositoryPort repositoryPort;

    @Override
    public Page<Price> getAllPrices(Pageable pageable) {
       return repositoryPort.findAll(pageable);
    }


    
}
