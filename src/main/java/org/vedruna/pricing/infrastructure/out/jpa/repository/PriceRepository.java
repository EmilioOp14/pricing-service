package org.vedruna.pricing.infrastructure.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedruna.pricing.infrastructure.out.jpa.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer>{

}
