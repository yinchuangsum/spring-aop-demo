package com.ycsum.aopdemo.aspect;

import com.ycsum.aopdemo.annotation.EnableLogging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(enableLogging)")
    public Object log(ProceedingJoinPoint joinPoint, EnableLogging enableLogging) throws Throwable {
        LOGGER.info("before");
        Object result = joinPoint.proceed();
        LOGGER.info(String.valueOf(result));
        LOGGER.info("after");
        return result;
    }
}
