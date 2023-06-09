package com.ps.at.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
