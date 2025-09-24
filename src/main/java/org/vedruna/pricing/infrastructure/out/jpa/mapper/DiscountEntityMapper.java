package org.vedruna.pricing.infrastructure.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.infrastructure.out.jpa.entity.DiscountEntity;

@Mapper(componentModel = "spring")
public interface DiscountEntityMapper {

    DiscountEntityMapper INSTANCE = Mappers.getMapper(DiscountEntityMapper.class);

    // Entity -> Domain
    Discount toDomain(DiscountEntity entity);

    // Domain -> Entity
    DiscountEntity toEntity(Discount domain);
}
