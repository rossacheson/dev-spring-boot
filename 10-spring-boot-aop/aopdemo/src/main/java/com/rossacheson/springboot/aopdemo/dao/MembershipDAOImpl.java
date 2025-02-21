package com.rossacheson.springboot.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addMember() {
        System.out.println(getClass() + " doing my DB work to add a membership account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " promptly going to sleep... zzz");
    }
}
