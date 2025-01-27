package com.rossacheson.cruddemo.dao;

import com.rossacheson.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
//        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName = :lastName", Student.class);

        query.setParameter("lastName", lastName);

        return query.getResultList();
    }
}
