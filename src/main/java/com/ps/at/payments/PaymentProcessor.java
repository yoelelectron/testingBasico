package com.ps.at.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse resp =  paymentGateway.requestPayment(new PaymentRequest(amount));

        if (resp.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        } else {
            return false;
        }
    }
}
