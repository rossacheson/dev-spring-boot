package com.rossacheson.springboot.thymeleafdemo.dao;

import com.rossacheson.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // Spring Data JPA creates the query automagically based on the method name
    public List<Employee> findAllByOrderByLastNameAsc();

}
