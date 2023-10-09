/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.soap.mock;

import com.jrevolt.banking_app.soap.SOAPClient;
import com.jrevolt.banking_app.soap.response.TransactionStatusResponse;
import org.springframework.ws.client.core.WebServiceTemplate;

@Mock
public class MockSOAPClient extends SOAPClient {

    public MockSOAPClient(WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }
    @Override
    public TransactionStatusResponse getTransactionStatus(String transactionId) {
        // Simulate a response for testing
        TransactionStatusResponse response = new TransactionStatusResponse();
        response.setStatus("SUCCESS");
        return response;
    }
}
