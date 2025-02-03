package com.rossacheson.springboot.aopdemo.dao;

import com.rossacheson.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " doing my DB work to add an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doing my DB work to do work");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " getServiceCode()");
        this.serviceCode = serviceCode;
    }
}
