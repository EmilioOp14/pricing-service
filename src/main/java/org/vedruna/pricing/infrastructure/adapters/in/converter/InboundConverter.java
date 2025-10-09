package org.vedruna.pricing.infrastructure.adapters.in.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.infrastructure.adapters.in.dto.PaymentMethodDto;
import org.vedruna.pricing.infrastructure.adapters.in.dto.PriceDto;


@Mapper(componentModel = "spring")
public interface InboundConverter {

    // DTO -> Domain
     
    Price toDomain(PriceDto dto);
    PaymentMethod toDomain(PaymentMethodDto dto);
    // Domain -> DTO
    @Mapping(target = "discountPercentage", source = "discount.percentage")
    @Mapping(target = "finalPrice", expression = "java(domain.getFinalPrice())")
    PriceDto toDto(Price domain);
    PaymentMethodDto toDto(PaymentMethod domain);
}
