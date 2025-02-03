package com.rossacheson.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopPointcutDeclarations{
    @Pointcut("execution(public * com.rossacheson.springboot.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}
    @Pointcut("execution(public * com.rossacheson.springboot.aopdemo.dao.*.get*(..))")
    public void daoGetter() {}
    @Pointcut("execution(public * com.rossacheson.springboot.aopdemo.dao.*.set*(..))")
    public void doaSetter() {}
    @Pointcut("forDaoPackage() && !(daoGetter() || doaSetter())")
    public void forDaoPackageNoGetterSetter() {}
}
