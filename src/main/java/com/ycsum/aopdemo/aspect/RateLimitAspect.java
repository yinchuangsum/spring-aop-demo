package com.ycsum.aopdemo.aspect;

import com.ycsum.aopdemo.SecurityContext;
import com.ycsum.aopdemo.User;
import com.ycsum.aopdemo.annotation.RateLimited;
import org.apache.commons.lang3.tuple.Pair;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(0)
public class RateLimitAspect {
    public final Map<Pair<User, String>, Integer> rateCounter;


    public RateLimitAspect() {
        rateCounter = new HashMap<>();
    }

    @Around("@annotation(rateLimited)")
    public Object rateLimit(ProceedingJoinPoint joinPoint, RateLimited rateLimited) throws Throwable {
        User currentUser = SecurityContext.getCurrentUser();
        Pair<User, String> pair = Pair.of(currentUser, rateLimited.name());
        Integer counter = rateCounter.get(pair);

        if (counter == null) {
            rateCounter.put(pair, 1);
            return joinPoint.proceed();
        }

        if (counter < rateLimited.rate()) {
            rateCounter.put(pair, counter +1);
            return joinPoint.proceed();
        }

        throw new IllegalAccessError("exceed limit");
    }
}
