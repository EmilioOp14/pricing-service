package org.vedruna.pricing.infrastructure.adapters.in;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.in.GetAPriceByIdUseCase;
import org.vedruna.pricing.domain.port.in.GetAllPricesUseCase;
import org.vedruna.pricing.infrastructure.adapters.in.converter.InboundConverter;
import org.vedruna.pricing.infrastructure.adapters.in.dto.PriceDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1/prices")
@AllArgsConstructor
@Validated
@Tag(
    name = "Prices API",
    description = "Endpoints to obain prices data."
)
public class PriceController {
 
    InboundConverter converter;
    GetAllPricesUseCase getAllPricesUseCase;
    GetAPriceByIdUseCase getAPriceByIdUseCase;

     // ----------------------------------------------------
    // GET ALL PRICES
    // ----------------------------------------------------
    @Operation(
        summary = "Get all prices",
        description = "Returns a paginated list of prices, including their associated payment methods.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Prices list obtained successfully",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PriceDto.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/")
    public Page<PriceDto> getAllPrices(@Parameter(description = "Pageable parameters (page, size, sort)") Pageable pageable) {
        log.info("Get all prices requested (page={}, size={}, sort={})", pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return getAllPricesUseCase.getAllPrices(pageable)
                .map(converter::toDto);
    }

    // ----------------------------------------------------
    // GET PRICE BY ID
    // ----------------------------------------------------
    @Operation(
        summary = "Get a price by ID",
        description = "Returns a price by its ID.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Price obtained successfully",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PriceDto.class))
            ),
            @ApiResponse(responseCode = "404", description = "Price not found"),
            @ApiResponse(responseCode = "400", description = "Invalid ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/{id}")
    public PriceDto getAPriceById(@Parameter(description = "Price ID", example = "1") 
    @PathVariable @Positive(message = "The id must be valid") Integer id) {
        log.info("Get price by id requested (id={})", id);
         Price price = getAPriceByIdUseCase.getAPrice(id);
    log.debug("Price found: {}", converter.toDto(price));
    return converter.toDto(price);
    }
}
