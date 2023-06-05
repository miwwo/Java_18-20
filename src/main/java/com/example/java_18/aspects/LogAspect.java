package com.example.java_18.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class LogAspect {
    @Before("allServiceMethods()")
    public void logParameters(JoinPoint joinPoint) {
        log.info("Time: {}", LocalDateTime.now());
        log.info("Signature: {}", joinPoint.getSignature());
        log.info("Parameters: {}", joinPoint.getArgs());
    }
    @Pointcut("within(com.example.java_18.service.*)")
    public void allServiceMethods() {}
}
