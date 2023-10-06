package com.jrevolt.banking_app.controller;

import com.jrevolt.banking_app.soap.SOAPClient;
import com.jrevolt.banking_app.soap.response.TransactionStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public record PaymentController(SOAPClient soapClient) {
    @PostMapping("/initiatePayment")
    public String initiatePayment(@RequestBody PaymentRequest paymentRequest) {
        // Simulate payment initiation logic
        boolean paymentSuccess = processPayment(paymentRequest);

        if (paymentSuccess) {
            // Call SOAP service to get transaction status
            String transactionId = generateTransactionId();
            TransactionStatusResponse response = soapClient.getTransactionStatus(transactionId);

            // Process the SOAP response
            if (response != null && response.getStatus().equals("SUCCESS")) {
                return "Payment initiated successfully. Transaction status: Successful";
            } else {
                return "Payment initiated successfully. Transaction status: Failed";
            }
        } else {
            return "Payment initiation failed.";
        }
    }

    private boolean processPayment(PaymentRequest paymentRequest) {
        // Simulate payment processing logic
        // In a real application, this method would interact with the payment provider
        // and return true if the payment was successful, false otherwise.
        return true;
    }

    private String generateTransactionId() {
        // Generate a unique transaction ID (for demonstration purposes, a random ID is generated)
        return String.valueOf((int) (Math.random() * 100000));
    }
}
