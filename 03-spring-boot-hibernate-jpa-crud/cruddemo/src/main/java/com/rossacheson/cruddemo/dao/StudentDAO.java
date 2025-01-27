package com.rossacheson.cruddemo.dao;

import com.rossacheson.cruddemo.entity.Student;

import java.util.List;

// Student Data Access Object
public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
}
