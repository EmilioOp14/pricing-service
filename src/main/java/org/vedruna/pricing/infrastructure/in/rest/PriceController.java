package org.vedruna.pricing.infrastructure.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.pricing.application.port.in.GetAllPricesUseCase;
import org.vedruna.pricing.application.port.in.GetPriceByIdUseCase;
import org.vedruna.pricing.infrastructure.in.rest.dto.PriceDto;
import org.vedruna.pricing.infrastructure.in.rest.mapper.PriceDtoMapper;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequiredArgsConstructor
public class PriceController {

    private final GetAllPricesUseCase getAllPricesUseCase;
    private final GetPriceByIdUseCase getPriceByIdUseCase;
    private final PriceDtoMapper priceDtoMapper;

    @Operation(summary = "Get all prices", description = "Returns paginated list of prices")
    @GetMapping("/prices")
    public Page<PriceDto> getAll(Pageable pageable) {
        return getAllPricesUseCase.getAllPrices(pageable)
                .map(priceDtoMapper::toDto);
    }

    @Operation(summary = "Get price by id", description = "Returns a price by id")
    @GetMapping("/prices/{id}")
    public PriceDto getById(@PathVariable Integer id) {
        return priceDtoMapper.toDto(getPriceByIdUseCase.getPriceById(id));
    }
}
