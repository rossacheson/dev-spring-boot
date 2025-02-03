package com.rossacheson.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLoggingAspect {
    // this is where we add all of our related advices for cloud logging
    @Before("com.rossacheson.springboot.aopdemo.aspect.AopPointcutDeclarations.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("=========> Logging to Cloud in async fashion");
    }
}
