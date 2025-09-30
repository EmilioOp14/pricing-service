package org.vedruna.pricing.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.vedruna.pricing.application.port.out.PriceRepositoryPort;
import org.vedruna.pricing.domain.model.Price;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class GetPriceByIdServiceTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private GetPriceByIdService getPriceByIdService;

    public GetPriceByIdServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnPriceById() {
        // given
        Price price = new Price(1, 100, 1.99f, null);
        when(priceRepositoryPort.findById(1)).thenReturn(price);

        // when
        Price result = getPriceByIdService.getPriceById(1);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getCoinsAmount()).isEqualTo(100);
        assertThat(result.getPrice()).isEqualTo(1.99f);
    }

    @Test
    void shouldThrowExceptionWhenPriceNotFound() {
        // given
        when(priceRepositoryPort.findById(99)).thenThrow(new NoSuchElementException("Price not found"));

        // then
        assertThatThrownBy(() -> getPriceByIdService.getPriceById(99))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Price not found");
    }
}
