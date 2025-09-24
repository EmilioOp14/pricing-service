package org.vedruna.pricing.infrastructure.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedruna.pricing.infrastructure.out.jpa.entity.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer>{

}
