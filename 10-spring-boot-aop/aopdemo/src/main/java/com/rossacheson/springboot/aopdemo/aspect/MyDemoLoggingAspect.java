package com.rossacheson.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    @Pointcut("execution(public * com.rossacheson.springboot.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeMethodAdvice() {
        System.out.println("=========> Executing @Before advice on dao method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("=========> Performing fancy API analytics on dao method");
    }
}
