package com.rossacheson.springboot.aopdemo.aspect;

import com.rossacheson.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @AfterReturning(
            pointcut = "execution(* com.rossacheson.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterReturning on method: " + method);
        System.out.println("====> Result is: " + result);

        // post-process the data
        convertAccountNameToUpperCase(result);
        System.out.println("====> Updated result is: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.rossacheson.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "e"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable e) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterThrowing on method: " + method);
        System.out.println("====> Exception is: " + e);
    }

    @After("execution(* com.rossacheson.springboot.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* com.rossacheson.springboot.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune( ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("Result is: " + result);
        System.out.println("Elapsed time: " + (end - begin)/1000.0 + " seconds\n");

        return result;
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }
}
