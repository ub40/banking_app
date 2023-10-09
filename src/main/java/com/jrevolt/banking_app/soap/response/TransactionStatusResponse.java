/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.soap.response;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "TransactionStatusResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionStatusResponse {

    @XmlElement(name = "Status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
