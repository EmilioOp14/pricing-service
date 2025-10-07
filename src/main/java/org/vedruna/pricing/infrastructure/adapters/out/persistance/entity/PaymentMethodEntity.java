package org.vedruna.pricing.infrastructure.adapters.out.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment_methods")
public class PaymentMethodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_method")
    private Integer id;

    @Column(name = "payment_method", nullable = false, unique = true)
    private String methodName;
}
