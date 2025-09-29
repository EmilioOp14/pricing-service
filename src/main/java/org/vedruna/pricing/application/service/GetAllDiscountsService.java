package org.vedruna.pricing.application.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vedruna.pricing.application.port.in.GetAllDiscountsUseCase;
import org.vedruna.pricing.application.port.out.DiscountRepositoryPort;
import org.vedruna.pricing.domain.model.Discount;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAllDiscountsService implements GetAllDiscountsUseCase {

    private final DiscountRepositoryPort repositoryPort;

    @Override
    public Page<Discount> getAllDiscounts(Pageable pageable) {
        return repositoryPort.findAll(pageable);
    }

}
