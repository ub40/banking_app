/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.soap;

import com.jrevolt.banking_app.soap.request.TransactionStatusRequest;
import com.jrevolt.banking_app.soap.response.TransactionStatusResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class SOAPClient extends WebServiceGatewaySupport {
    @Value("${soap.endpoint.url}")
    private String soapEndpointUrl;
    private final WebServiceTemplate webServiceTemplate;

    // Constructor to accept WebServiceTemplate
    public SOAPClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public TransactionStatusResponse getTransactionStatus(String transactionId) {
        TransactionStatusRequest request = new TransactionStatusRequest();
        request.setTransactionId(transactionId);

        return (TransactionStatusResponse) webServiceTemplate.marshalSendAndReceive(soapEndpointUrl, request);
    }
}
