package com.rossacheson.springboot.aopdemo.aspect;

import com.rossacheson.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging
    @Before("com.rossacheson.springboot.aopdemo.aspect.AopPointcutDeclarations.forDaoPackageNoGetterSetter()")
    public void beforeMethodAdvice(JoinPoint joinPoint) {
        System.out.println("=========> Executing @Before advice on dao method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display the method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if(arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }
}
