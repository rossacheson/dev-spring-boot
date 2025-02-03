package com.rossacheson.springboot.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + " doing my DB work to add a membership account");
    }
}
