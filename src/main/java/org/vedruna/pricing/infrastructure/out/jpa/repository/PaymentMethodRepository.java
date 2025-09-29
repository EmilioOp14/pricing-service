package org.vedruna.pricing.infrastructure.out.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedruna.pricing.infrastructure.out.jpa.entity.PaymentMethodEntity;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Integer>{

}
