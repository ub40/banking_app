/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.configurations;

import com.jrevolt.banking_app.soap.mock.MockSOAPClient;
import com.jrevolt.banking_app.soap.SOAPClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SOAPConfig {

    @Bean
    public SOAPClient soapClient() {
        // Use the mock SOAPClient for testing
        return new MockSOAPClient(webServiceTemplate());
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        // Create and configure a WebServiceTemplate
        // Use the marshaller configured in marshaller() method
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(marshaller());
        return webServiceTemplate;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        // Create and configure a Jaxb2Marshaller
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.jrevolt.banking_app.soap"); // Set your package to scan
        return marshaller;
    }
}
