/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.soap.request;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "TransactionStatusRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionStatusRequest {

    @XmlElement(name = "TransactionId")
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}