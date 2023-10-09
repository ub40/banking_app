/*
 * Copyright (c) 2023-2023 JRevolt.
 * Author: Urfan Beijlerbeijli.
 * Licensed under the MIT License
 * All rights reserved.
 */


package com.jrevolt.banking_app.soap.mock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mock {
}
