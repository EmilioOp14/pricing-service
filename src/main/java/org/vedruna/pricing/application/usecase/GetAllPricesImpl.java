package org.vedruna.pricing.application.usecase;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.in.GetAllPricesUseCase;
import org.vedruna.pricing.domain.port.out.DiscountJpaRepository;
import org.vedruna.pricing.domain.port.out.PriceJpaRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class GetAllPricesImpl implements GetAllPricesUseCase {

    PriceJpaRepository priceRepository;
    DiscountJpaRepository discountRepository;

    // ...existing code...
@Override
public Page<Price> getAllPrices(Pageable pageable) {
    Page<Price> prices = priceRepository.getAllPrices(pageable);
    prices.forEach(price -> {
        Discount activeDiscount = findActiveDiscountForPrice(price);
        price.setDiscount(activeDiscount);
    });
    return prices;
}

@Override
public Discount findActiveDiscountForPrice(Price price) {
   Discount discount = discountRepository.findActiveDiscountForPrice(price.getId(), LocalDateTime.now());
   if (discount != null) {
       return discount;
   }
    return null;
}


}
