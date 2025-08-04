package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("🔁 [LOG] Method execution started: " + joinPoint.getSignature());
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("✅ [LOG] Method execution ended: " + joinPoint.getSignature());
        System.out.println("⏱ Execution Time: " + (end - start) + " ms");

        return result;
    }
}