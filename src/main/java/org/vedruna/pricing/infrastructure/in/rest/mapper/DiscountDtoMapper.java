package org.vedruna.pricing.infrastructure.in.rest.mapper;

import org.mapstruct.Mapper;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.infrastructure.in.rest.dto.DiscountDto;

@Mapper(componentModel = "spring", uses = { PriceDtoMapper.class })
public interface DiscountDtoMapper {
    DiscountDto toDto(Discount domain);
    Discount toDomain(DiscountDto dto);
}
