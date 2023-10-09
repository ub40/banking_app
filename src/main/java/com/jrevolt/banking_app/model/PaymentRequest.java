/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.model;
public record PaymentRequest(String amount, String currency, String cardNumber, String expiry, String cvv) {}

