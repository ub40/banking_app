/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.controller;

import com.jrevolt.banking_app.model.PaymentRequest;
import com.jrevolt.banking_app.services.PaymentService;
import com.jrevolt.banking_app.soap.SOAPClient;
import com.jrevolt.banking_app.soap.response.TransactionStatusResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public record PaymentController(PaymentService paymentService, SOAPClient soapClient) {

    @PostMapping("/initiatePayment")
    public String initiatePayment(@RequestBody PaymentRequest paymentRequest) {
        return processPayment(paymentRequest);
    }

    private String processPayment(PaymentRequest paymentRequest) {
         /*Simulate payment processing logic
         In a real application, this method would interact with the payment provider
         and return true if the payment was successful, false otherwise.

         For demonstration purposes, I'll assume payment is always successful.
         Here, I am  also calling getTransactionStatus to demonstrate its usage.*/
        String transactionId = generateTransactionId();
        TransactionStatusResponse response = paymentService.getTransactionStatus(transactionId);

        boolean paymentSuccess = true;

        if (paymentSuccess) {
            return "Payment initiated successfully for amount " + paymentRequest.amount()
                    + " " + paymentRequest.currency() + ". Transaction status: " + response.getStatus();
        } else {
            return "Payment initiation failed.";
        }
    }

    private String generateTransactionId() {
        // Generate a unique transaction ID (for demonstration purposes, a random ID is generated)
        return String.valueOf((int) (Math.random() * 100000));
    }
}
