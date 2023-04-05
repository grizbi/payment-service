package com.example.paymentservice.service;

import com.example.paymentservice.repository.Account;
import com.example.paymentservice.repository.AccountRepository;
import com.example.paymentservice.service.model.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final AccountRepository accountRepository;

    @Override
    public Boolean processPayment(PaymentRequest paymentRequest) {
        Account userAccount = accountRepository.findByUserId(paymentRequest.getUserId()).orElseThrow();

        if (isUserEligibleForPayment(userAccount, paymentRequest)) {
            userAccount.setBalance(userAccount.getBalance() - paymentRequest.getCost());
            accountRepository.save(userAccount);
            return true;
        }
        return false;
    }

    private boolean isUserEligibleForPayment(Account userAccount, PaymentRequest paymentRequest) {
        return paymentRequest.getCost() <= userAccount.getBalance();
    }
}
