package com.jrevolt.banking_app.soap;

import com.jrevolt.banking_app.soap.request.TransactionStatusRequest;
import com.jrevolt.banking_app.soap.response.TransactionStatusResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

public class SOAPClient {
    @Value("${soap.endpoint.url}")
    private String soapEndpointUrl;

    private final WebServiceTemplate webServiceTemplate;

    public SOAPClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public TransactionStatusResponse getTransactionStatus(String transactionId) {
        TransactionStatusRequest request = new TransactionStatusRequest();
        request.setTransactionId(transactionId);

        return (TransactionStatusResponse) webServiceTemplate.marshalSendAndReceive(soapEndpointUrl, request);
    }
}
