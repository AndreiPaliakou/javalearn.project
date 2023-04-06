package com.apaliakou.homework1201;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Reviewers {
    ThisCodeSmells[] value();
}
