package org.vedruna.pricing.infrastructure.adapters.out.persistance;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.out.DiscountJpaRepository;
import org.vedruna.pricing.domain.port.out.PriceJpaRepository;
import org.vedruna.pricing.infrastructure.adapters.out.converter.OutBoundConverter;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.DiscountEntity;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.repository.DiscountRepository;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.repository.PriceRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class JpaRepositoryImpl implements PriceJpaRepository, DiscountJpaRepository {

    OutBoundConverter converter;
    PriceRepository priceRepository;
    DiscountRepository discountRepository;

    @Override
    public Page<Price> getAllPrices(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now();
        return priceRepository.findAll(pageable)
            .map(entity -> {
                Price p = converter.toDomain(entity);
                DiscountEntity de = discountRepository.findDiscountByPriceId(entity.getId(), now); // ver punto 3
                if (de != null) {
                    p.setDiscount(converter.toDomain(de));
                }
                return p;
            });
    }

     @Override
    public Price getAPriceById(Integer id) {
        LocalDateTime now = LocalDateTime.now();
        Price p = priceRepository.findById(id)
            .map(converter::toDomain)
            .orElseThrow(() -> new RuntimeException("Price with id " + id + " not found"));
        DiscountEntity de = discountRepository.findDiscountByPriceId(id, now); // ver punto 3
        if (de != null) {
            p.setDiscount(converter.toDomain(de));
        }
        return p;
    }

    @Override
    public Discount findActiveDiscountForPrice(Integer priceId, LocalDateTime now) {
        DiscountEntity entity = discountRepository.findDiscountByPriceId(priceId, now);
        return entity != null ? converter.toDomain(entity) : null;
    }


}
