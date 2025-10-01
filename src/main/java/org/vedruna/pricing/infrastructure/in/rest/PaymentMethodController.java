package org.vedruna.pricing.infrastructure.in.rest;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.pricing.application.port.in.CreatePaymentMethodUseCase;
import org.vedruna.pricing.application.port.in.GetAllPaymentMethodsUseCase;
import org.vedruna.pricing.application.port.in.GetPaymentMethodByIdUseCase;
import org.vedruna.pricing.domain.model.PaymentMethod;
import org.vedruna.pricing.infrastructure.in.rest.dto.PaymentMethodDto;
import org.vedruna.pricing.infrastructure.in.rest.mapper.PaymentMethodDtoMapper;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    private final GetAllPaymentMethodsUseCase getAllPaymentMethodsUseCase;
    private final CreatePaymentMethodUseCase createPaymentMethodUseCase;
    private final GetPaymentMethodByIdUseCase getPaymentMethodByIdUseCase;
    private final PaymentMethodDtoMapper paymentMethodDtoMapper;

    @Operation(summary = "Get all payment methods", description = "Returns paginated list of payment methods")
    @GetMapping
    public Page<PaymentMethodDto> getAll(Pageable pageable) {
        return getAllPaymentMethodsUseCase.getAllPaymentMethods(pageable).map(paymentMethodDtoMapper::toDto);
    }

    @Operation(summary = "Get payment method by id", description = "Returns a payment method by id")
    @GetMapping("/{id}")
public PaymentMethod getById(@PathVariable Integer id) {
    return getPaymentMethodByIdUseCase.getPaymentMethodById(id);
}

@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentMethodDto create(@Valid @RequestBody PaymentMethodDto dto) {
        PaymentMethod domain = paymentMethodDtoMapper.toDomain(dto);
        PaymentMethod saved = createPaymentMethodUseCase.createPaymentMethod(domain);
        return paymentMethodDtoMapper.toDto(saved);
    }
}
