package org.vedruna.pricing.infrastructure.adapters.out.persistance.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.DiscountEntity;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.PriceEntity;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer>{

    @Query("SELECT d FROM DiscountEntity d WHERE d.price.id = :priceId AND :now BETWEEN d.startDate AND d.endDate")
    DiscountEntity findDiscountByPriceId(Integer priceId, LocalDateTime now);
    
}
