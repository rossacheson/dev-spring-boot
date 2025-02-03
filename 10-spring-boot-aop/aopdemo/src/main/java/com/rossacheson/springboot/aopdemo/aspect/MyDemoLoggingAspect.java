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
    @Pointcut("execution(public * com.rossacheson.springboot.aopdemo.dao.*.get*(..))")
    private void daoGetter() {}
    @Pointcut("execution(public * com.rossacheson.springboot.aopdemo.dao.*.set*(..))")
    private void doaSetter() {}
    @Pointcut("forDaoPackage() && !(daoGetter() || doaSetter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeMethodAdvice() {
        System.out.println("\n=========> Executing @Before advice on dao method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("=========> Performing fancy API analytics on dao method");
    }
}
