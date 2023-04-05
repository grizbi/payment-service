package com.example.paymentservice.controller;

import com.example.paymentservice.service.PaymentService;
import com.example.paymentservice.service.model.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<Boolean> processPayment(@RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentService.processPayment(paymentRequest));
    }

}
