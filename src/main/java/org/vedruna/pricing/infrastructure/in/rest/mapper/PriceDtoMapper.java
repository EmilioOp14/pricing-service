package org.vedruna.pricing.infrastructure.in.rest.mapper;

import org.mapstruct.Mapper;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.infrastructure.in.rest.dto.PriceDto;

@Mapper(componentModel = "spring", uses = { PaymentMethodDtoMapper.class })
public interface PriceDtoMapper {
    PriceDto toDto(Price domain);
    Price toDomain(PriceDto dto);
}
