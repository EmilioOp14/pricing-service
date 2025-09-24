package org.vedruna.pricing.infrastructure.out.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedruna.pricing.infrastructure.out.jpa.entity.PaymentMethodEntity;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Integer>{

    Optional<PaymentMethodEntity> findByMethodName(String methodName);

}
