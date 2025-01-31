package com.rossacheson.springboot.mappingdemo.dao;

import com.rossacheson.springboot.mappingdemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
}
