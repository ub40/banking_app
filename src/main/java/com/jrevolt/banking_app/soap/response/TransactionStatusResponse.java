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
