package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.showBooks(..))")
    public void beforeShowBooks() {
        System.out.println("📢 [Before] BookService is about to show books...");
    }

    @After("execution(* com.library.service.BookService.showBooks(..))")
    public void afterShowBooks() {
        System.out.println("📢 [After] BookService finished showing books.");
    }
}