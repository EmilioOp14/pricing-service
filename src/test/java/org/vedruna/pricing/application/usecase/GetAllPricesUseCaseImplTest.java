package org.vedruna.pricing.application.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.domain.model.Price;
import org.vedruna.pricing.domain.port.out.PriceJpaRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GetAllPricesUseCaseImplTest {

    @Mock
    private PriceJpaRepository repository;

    @InjectMocks
    private GetAllPricesImpl useCase;

    public GetAllPricesUseCaseImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllPrices() {
        // given
        List<Price> prices = List.of(new Price(1, 100, 1.99f, null));
        Page<Price> page = new PageImpl<>(prices);
        when(repository.getAllPrices(any(Pageable.class))).thenReturn(page);

        // when
        Page<Price> result = useCase.getAllPrices(Pageable.unpaged());

        // then
        assertThat(result.getContent()).hasSize(1);
        verify(repository, times(1)).getAllPrices(any(Pageable.class));
    }
}
