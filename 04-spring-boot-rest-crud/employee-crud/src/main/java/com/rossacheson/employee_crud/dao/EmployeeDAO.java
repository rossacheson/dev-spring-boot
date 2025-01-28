package com.rossacheson.employee_crud.dao;

import com.rossacheson.employee_crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
