package org.vedruna.pricing.infrastructure.adapters.in;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.in.GetAPriceByIdUseCase;
import org.vedruna.pricing.domain.port.in.GetAllPricesUseCase;
import org.vedruna.pricing.infrastructure.adapters.in.converter.InboundConverter;
import org.vedruna.pricing.infrastructure.adapters.in.dto.PriceDto;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InboundConverter converter;

    @MockBean
    private GetAllPricesUseCase getAllPricesUseCase;

    @MockBean
    private GetAPriceByIdUseCase getAPriceByIdUseCase;

    @Test
    void shouldReturnAllPrices() throws Exception {
        Price domain = new Price(1, 100, 1.99f, null);
        PriceDto dto = new PriceDto(1, 100, 1.99f, null);

        Mockito.when(getAllPricesUseCase.getAllPrices(any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(domain)));
        Mockito.when(converter.toDto(domain)).thenReturn(dto);

        mockMvc.perform(get("/api/v1/prices/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1));
    }

    @Test
    void shouldReturnPriceById() throws Exception {
        Price domain = new Price(1, 100, 1.99f, null);
        PriceDto dto = new PriceDto(1, 100, 1.99f, null);

        Mockito.when(getAPriceByIdUseCase.getAPrice(1)).thenReturn(domain);
        Mockito.when(converter.toDto(domain)).thenReturn(dto);

        mockMvc.perform(get("/api/v1/prices/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
}
