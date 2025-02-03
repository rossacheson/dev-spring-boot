package com.rossacheson.springboot.aopdemo.dao;

import com.rossacheson.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " doing my DB work to add an account");
    }
}
