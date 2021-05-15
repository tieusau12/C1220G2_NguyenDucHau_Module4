package com.example.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LibraryAop {
    private static int count = 0;

    @Pointcut("execution(* com.example.book.controller.RenterController.showRentBook(..))")
    public void showRentBook() {
    }

    @After("showRentBook()")
    public void beforeController(JoinPoint joinPoint) {
        System.err.println("Book has been rented " + joinPoint.getSignature().getName()
                + " - at : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.book.controller.RenterController.returnBook(..))")
    public void returnBook() {
    }

    @After("returnBook()")
    public void afterController(JoinPoint joinPoint) {
        System.err.println("Book has been returned" + joinPoint.getSignature().getName() + " - at : "
                + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.book.controller.RenterController.*(..))")
    public void checkCountLog() {
    }

    @Before("checkCountLog()")
    public void count(JoinPoint joinPoint) {

        System.err.println("Total views " + ++count);

    }
}
