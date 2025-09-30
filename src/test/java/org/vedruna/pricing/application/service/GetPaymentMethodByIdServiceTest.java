package org.vedruna.pricing.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.vedruna.pricing.application.port.out.PaymentMethodRepositoryPort;
import org.vedruna.pricing.domain.model.PaymentMethod;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class GetPaymentMethodByIdServiceTest {

    @Mock
    private PaymentMethodRepositoryPort repositoryPort;

    @InjectMocks
    private GetPaymentMethodByIdService service;

    public GetPaymentMethodByIdServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnPaymentMethodById() {
        // given
        PaymentMethod pm = new PaymentMethod(1, "Credit Card");
        when(repositoryPort.findById(1)).thenReturn(pm);

        // when
        PaymentMethod result = service.getPaymentMethodById(1);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getMethodName()).isEqualTo("Credit Card");
    }

    @Test
    void shouldThrowExceptionWhenNotFound() {
        // given
        when(repositoryPort.findById(99)).thenThrow(new NoSuchElementException("Payment method not found"));

        // then
        assertThatThrownBy(() -> service.getPaymentMethodById(99))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Payment method not found");
    }
}
