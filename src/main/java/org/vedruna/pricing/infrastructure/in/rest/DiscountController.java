package org.vedruna.pricing.infrastructure.in.rest;

import org.springframework.web.bind.annotation.RestController;
import org.vedruna.pricing.application.port.in.GetAllDiscountsUseCase;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.infrastructure.in.rest.dto.DiscountDto;
import org.vedruna.pricing.infrastructure.in.rest.mapper.DiscountDtoMapper;

import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
public class DiscountController {

    private final GetAllDiscountsUseCase getAllDiscountsUseCase;
    private final DiscountDtoMapper discountDtoMapper;

    @GetMapping("/discounts")
public Page<DiscountDto> getAll(Pageable pageable) {
    return getAllDiscountsUseCase.getAllDiscounts(pageable)
             .map(discountDtoMapper::toDto);
}
    

}
