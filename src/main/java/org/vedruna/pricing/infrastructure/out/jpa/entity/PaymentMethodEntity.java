package org.vedruna.pricing.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter 
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
