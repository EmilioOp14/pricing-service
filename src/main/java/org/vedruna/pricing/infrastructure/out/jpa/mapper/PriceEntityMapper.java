package org.vedruna.pricing.infrastructure.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.infrastructure.out.jpa.entity.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    PriceEntityMapper INSTANCE = Mappers.getMapper(PriceEntityMapper.class);

    // Entity -> Domain
    Price toDomain(PriceEntity entity);
    // Domain -> Entity
    PriceEntity toEntity(Price domain);

}
