package org.vedruna.pricing.infrastructure.adapters.out.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.DiscountEntity;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.PaymentMethodEntity;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.PriceEntity;


@Mapper(componentModel = "spring")
public interface OutBoundConverter {

    @Mapping(target = "paymentMethod", source = "paymentMethodEntity")
    Price toDomain(PriceEntity entity);

    @Mapping(target = "paymentMethodEntity", source = "paymentMethod")
    PriceEntity toEntity(Price domain);

    // Discount
    @Mapping(target = "percentage", source = "discount")
    @Mapping(target = "price", source = "price") 
    Discount toDomain(DiscountEntity entity);

    @Mapping(target = "discount", source = "percentage")
    @Mapping(target = "price", source = "price") 
    DiscountEntity toEntity(Discount domain);


    PaymentMethodEntity toEntity(PaymentMethod domain);
    PaymentMethod toDomain(PaymentMethodEntity entity);

}
