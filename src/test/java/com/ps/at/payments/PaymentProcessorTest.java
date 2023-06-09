package com.ps.at.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway pg;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup(){
        pg = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(pg);
    }

    @Test
    public void paymentSuccess() {

        // preparacion - arrange
        //PaymentGateway pg = Mockito.mock(PaymentGateway.class);
        Mockito.when(pg.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        //PaymentProcessor paymentProcessor = new PaymentProcessor(pg);

        // definiciion - act
        boolean result = paymentProcessor.makePayment(1000);

        // afirmacion - assert
        assertTrue(result);
    }

    @Test
    public void paymentFailed() {

        //PaymentGateway pg = Mockito.mock(PaymentGateway.class);
        Mockito.when(pg.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        //PaymentProcessor paymentProcessor = new PaymentProcessor(pg);

        assertFalse(paymentProcessor.makePayment(1000));
    }
}