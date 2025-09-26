package org.vedruna.pricing.infrastructure.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.pricing.application.port.in.GetAllPaymentMethodsUseCase;
import org.vedruna.pricing.domain.model.PaymentMethod;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentMethodController {

    private final GetAllPaymentMethodsUseCase getAllPaymentMethodsUseCase;

    @GetMapping("/payment-methods")
    public List<PaymentMethod> getAll() {
        return getAllPaymentMethodsUseCase.getAllPaymentMethods();
    }
}
