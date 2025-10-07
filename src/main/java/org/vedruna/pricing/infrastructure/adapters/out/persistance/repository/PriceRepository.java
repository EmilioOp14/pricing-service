package org.vedruna.pricing.infrastructure.adapters.out.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedruna.pricing.infrastructure.adapters.out.persistance.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer>{

}
