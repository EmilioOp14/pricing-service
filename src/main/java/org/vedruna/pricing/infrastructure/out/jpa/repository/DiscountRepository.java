package org.vedruna.pricing.infrastructure.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedruna.pricing.infrastructure.out.jpa.entity.DiscountEntity;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer>{

}
