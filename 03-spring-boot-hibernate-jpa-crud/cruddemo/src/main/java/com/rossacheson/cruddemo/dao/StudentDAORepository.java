package com.rossacheson.cruddemo.dao;

import com.rossacheson.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAORepository implements StudentDAO {

    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
