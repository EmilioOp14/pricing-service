package org.vedruna.pricing.infrastructure.in.rest.mapper;

import org.mapstruct.Mapper;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.infrastructure.in.rest.dto.PaymentMethodDto;

@Mapper(componentModel = "spring")
public interface PaymentMethodDtoMapper {
    PaymentMethodDto toDto(PaymentMethod domain);
    PaymentMethod toDomain(PaymentMethodDto dto);
}
