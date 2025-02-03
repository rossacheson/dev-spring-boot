package com.rossacheson.springboot.aopdemo.dao;

import com.rossacheson.springboot.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
}
