package com.rossacheson.employee_crud.service;

import com.rossacheson.employee_crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
