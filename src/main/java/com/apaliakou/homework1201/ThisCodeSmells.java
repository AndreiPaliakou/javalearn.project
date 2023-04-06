package com.apaliakou.homework1201;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Reviewers.class)
public @interface ThisCodeSmells {
    String reviewer() default "John";
}
