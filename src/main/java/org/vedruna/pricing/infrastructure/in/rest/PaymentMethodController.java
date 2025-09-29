package org.vedruna.pricing.infrastructure.in.rest;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.pricing.application.port.in.GetAllPaymentMethodsUseCase;
import org.vedruna.pricing.application.port.in.GetPaymentMethodByIdUseCase;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.infrastructure.in.rest.dto.PaymentMethodDto;
import org.vedruna.pricing.infrastructure.in.rest.mapper.PaymentMethodDtoMapper;


@RestController
@RequiredArgsConstructor
public class PaymentMethodController {

    private final GetAllPaymentMethodsUseCase getAllPaymentMethodsUseCase;
    private final GetPaymentMethodByIdUseCase getPaymentMethodByIdUseCase;
    private final PaymentMethodDtoMapper paymentMethodDtoMapper;

    @GetMapping("/payment-methods")
    public Page<PaymentMethodDto> getAll(Pageable pageable) {
        return getAllPaymentMethodsUseCase.getAllPaymentMethods(pageable).map(paymentMethodDtoMapper::toDto);
    }

    @GetMapping("/payment-methods/{id}")
public PaymentMethod getById(@PathVariable Integer id) {
    return getPaymentMethodByIdUseCase.getPaymentMethodById(id);
}
}
