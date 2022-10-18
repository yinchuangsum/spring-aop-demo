package com.ycsum.aopdemo.aspect;

import com.ycsum.aopdemo.annotation.EnableTiming;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TimingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimingAspect.class);

    @Around("@annotation(enableTiming)")
    public Object logTime(ProceedingJoinPoint joinPoint, EnableTiming enableTiming) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.info(String.format("Time taken for class: %s, method: %s is %d ms",
                joinPoint.getSignature().getDeclaringType().getName(),
                joinPoint.getSignature().getName(),
                endTime - startTime));
        return proceed;
    }
}
