package org.vedruna.pricing.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.model.PaymentMethod;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class GetAllPaymentMethodsServiceTest {

    @Mock
    private PaymentMethodRepositoryPort repositoryPort;

    @InjectMocks
    private GetAllPaymentMethodsService service;

    public GetAllPaymentMethodsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllPaymentMethods() {
        // given
        PaymentMethod pm1 = new PaymentMethod(1, "Credit Card");
        PaymentMethod pm2 = new PaymentMethod(2, "PayPal");
        Pageable pageable = PageRequest.of(0, 10);
        Page<PaymentMethod> page = new PageImpl<>(Arrays.asList(pm1, pm2), pageable, 2);

        when(repositoryPort.findAll(pageable)).thenReturn(page);

        // when
        Page<PaymentMethod> result = service.getAllPaymentMethods(pageable);

        // then
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getContent().get(0).getMethodName()).isEqualTo("Credit Card");
    }
}
