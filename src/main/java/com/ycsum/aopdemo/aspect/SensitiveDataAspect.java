package com.ycsum.aopdemo.aspect;

import com.ycsum.aopdemo.SecurityContext;
import com.ycsum.aopdemo.User;
import com.ycsum.aopdemo.annotation.SensitiveConceal;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SensitiveDataAspect {

    public Object maskUser(Object user) {
        if (!(user instanceof User))
            return user;

        if (user.equals(SecurityContext.getCurrentUser()))
            return user;

        ((User) user).setPassword("");
        return user;
    }


    @Around("@annotation(sensitiveConceal)")
    public Object maskSensitiveData(ProceedingJoinPoint joinPoint, SensitiveConceal sensitiveConceal) throws Throwable {
        Object result = joinPoint.proceed();

        if (result instanceof Iterable) {
            ((Iterable<?>) result).forEach(this::maskUser);
        }

        return maskUser(result);
    }
}
