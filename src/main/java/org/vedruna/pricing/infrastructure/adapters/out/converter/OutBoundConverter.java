package org.vedruna.pricing.infrastructure.adapters.out.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.PaymentMethodEntity;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.PriceEntity;


@Mapper(componentModel = "spring")
public interface OutBoundConverter {


    // Entity → Domain
    @Mapping(target = "paymentMethod", source = "paymentMethodEntity")
    Price toDomain(PriceEntity entity);

    PaymentMethod toDomain(PaymentMethodEntity entity);

    // Domain → Entity
    @Mapping(target = "paymentMethodEntity", source = "paymentMethod")
    PriceEntity toEntity(Price domain);

    PaymentMethodEntity toEntity(PaymentMethod domain);
    
}
