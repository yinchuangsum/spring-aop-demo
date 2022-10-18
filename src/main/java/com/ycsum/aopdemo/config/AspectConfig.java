package com.ycsum.aopdemo.config;

import com.ycsum.aopdemo.aspect.LoggingAspect;
import com.ycsum.aopdemo.aspect.RateLimitAspect;
import com.ycsum.aopdemo.aspect.SensitiveDataAspect;
import com.ycsum.aopdemo.aspect.TimingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

//    @Bean
    public TimingAspect timingAspect() {
        return new TimingAspect();
    }

//    @Bean
    public SensitiveDataAspect sensitiveDataAspect() {
        return new SensitiveDataAspect();
    }

//    @Bean
    public RateLimitAspect rateLimitAspect() {
        return new RateLimitAspect();
    }
}
