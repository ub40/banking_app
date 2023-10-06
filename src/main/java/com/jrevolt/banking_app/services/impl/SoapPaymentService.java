package com.jrevolt.banking_app.services.impl;

import com.jrevolt.banking_app.services.PaymentService;
import com.jrevolt.banking_app.soap.SOAPClient;
import com.jrevolt.banking_app.soap.response.TransactionStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoapPaymentService implements PaymentService {
    private final SOAPClient soapClient;

    @Autowired
    public SoapPaymentService(SOAPClient soapClient) {
        this.soapClient = soapClient;
    }

    @Override
    public TransactionStatusResponse getTransactionStatus(String transactionId) {
        // Call the SOAP client to get the transaction status
        return soapClient.getTransactionStatus(transactionId);
    }
}
