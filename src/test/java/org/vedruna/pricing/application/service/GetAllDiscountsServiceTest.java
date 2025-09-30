package org.vedruna.pricing.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.application.port.out.DiscountRepositoryPort;
import org.vedruna.pricing.domain.model.Discount;
import org.vedruna.pricing.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class GetAllDiscountsServiceTest {

    @Mock
    private DiscountRepositoryPort repositoryPort;

    @InjectMocks
    private GetAllDiscountsService service;

    public GetAllDiscountsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllDiscounts() {
        // given
        Price price = new Price(1, 100, 1.99f, null);
        Discount d1 = new Discount(1, LocalDateTime.now(), LocalDateTime.now().plusDays(1), 10f, price);
        Discount d2 = new Discount(2, LocalDateTime.now(), LocalDateTime.now().plusDays(2), 15f, price);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Discount> page = new PageImpl<>(Arrays.asList(d1, d2), pageable, 2);

        when(repositoryPort.findAll(pageable)).thenReturn(page);

        // when
        Page<Discount> result = service.getAllDiscounts(pageable);

        // then
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getContent().get(0).getDiscount()).isEqualTo(10f);
    }
}
