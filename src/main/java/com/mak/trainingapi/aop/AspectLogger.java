package com.mak.trainingapi.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectLogger {

    @Pointcut("within(com.mak.trainingapi.controller.*)")
    void isEndpoint() {
    }

    @Pointcut("execution(* com.mak.trainingapi..* (..))")
    void allMethods() {
    }

    @Before("allMethods() && isEndpoint()")
    public void beforeEndpoint(JoinPoint p) {
        log.info("METHOD-START {}, args = [{}] ", p.getSignature().getName(), p.getArgs());
    }

    @AfterReturning(value = "allMethods() && isEndpoint()", returning = "result")
    public void afterEndpoint(JoinPoint p, Object result) {
        log.info("METHOD-END {}, result = [{}] ", p.getSignature().getName(), result);
    }
}
