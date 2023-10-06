package com.jrevolt.banking_app.services;

import com.jrevolt.banking_app.soap.response.TransactionStatusResponse;

public interface PaymentService {
    /**
     * @author Urfan Beylerbeyli
     * Retrieves the transaction status from the payment provider.
     *
     * @param transactionId The unique transaction ID associated with the payment.
     * @return Transaction status response.
     */
    TransactionStatusResponse getTransactionStatus(String transactionId);
}
