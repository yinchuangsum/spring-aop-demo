package com.ycsum.aopdemo.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RateLimited {
    @AliasFor("rate")
    int value() default 10;

    @AliasFor("value")
    int rate() default 10;

    String name();
}
