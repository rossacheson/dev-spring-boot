package com.rossacheson.springboot.aopdemo.dao;

import com.rossacheson.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " doing my DB work to add an account");
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();

        // add sample accounts
        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Luca", "Gold");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
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
