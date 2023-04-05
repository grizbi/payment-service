package com.example.paymentservice.service;

import com.example.paymentservice.service.model.PaymentRequest;

public interface PaymentService {

    /**
     * Processes payment for a customer.
     *
     * @param paymentRequest Request
     * @return boolean that concludes if payment went successfully.
     */
    Boolean processPayment(PaymentRequest paymentRequest);

}
