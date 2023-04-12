package com.example.other_tasks.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ExecutionTimeAspect {

    @Around("allServiceMethods()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("{} executed in {} ms", joinPoint.getSignature(), endTime - startTime);
        return result;
    }
    @Pointcut("execution(* com.example.other_tasks.services.*.*(..))")
    public void allServiceMethods() {}
}