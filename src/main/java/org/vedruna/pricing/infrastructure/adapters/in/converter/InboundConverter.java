package org.vedruna.pricing.infrastructure.adapters.in.converter;

import org.mapstruct.Mapper;
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
    PriceDto toDto(Price domain);
    PaymentMethodDto toDto(PaymentMethod domain);
}
