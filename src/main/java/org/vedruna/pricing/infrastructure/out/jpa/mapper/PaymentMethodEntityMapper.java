package org.vedruna.pricing.infrastructure.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.infrastructure.out.jpa.entity.PaymentMethodEntity;

@Mapper(componentModel = "spring")
public interface PaymentMethodEntityMapper {

    PaymentMethodEntityMapper INSTANCE = Mappers.getMapper(PaymentMethodEntityMapper.class);

    // Entity -> Domain
    PaymentMethod toDomain(PaymentMethodEntity entity);

    // Domain -> Entity
    PaymentMethodEntity toEntity(PaymentMethod domain);

}
