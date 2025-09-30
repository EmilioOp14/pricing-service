package org.vedruna.pricing.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.vedruna.pricing.application.port.out.PriceRepositoryPort;
import org.vedruna.pricing.domain.model.Price;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class GetAllPricesServiceTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private GetAllPricesService getAllPricesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

@Test
void shouldReturnAllPrices() {
    // given
    Price price1 = new Price(1, 100, 1.99f, null);
    Price price2 = new Price(2, 500, 8.49f, null);
    Pageable pageable = PageRequest.of(0, 10);

    Page<Price> page = new PageImpl<>(Arrays.asList(price1, price2), pageable, 2);

    when(priceRepositoryPort.findAll(pageable)).thenReturn(page);

    // when
    Page<Price> result = getAllPricesService.getAllPrices(pageable);

    // then
    assertThat(result.getContent()).hasSize(2);
    assertThat(result.getContent().get(0).getCoinsAmount()).isEqualTo(100);
    assertThat(result.getContent().get(1).getPrice()).isEqualTo(8.49f);
}

}
