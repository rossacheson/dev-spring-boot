package com.rossacheson.springboot.mappingdemo.dao;

import com.rossacheson.springboot.mappingdemo.entity.Course;
import com.rossacheson.springboot.mappingdemo.entity.Instructor;
import com.rossacheson.springboot.mappingdemo.entity.InstructorDetail;
import com.rossacheson.springboot.mappingdemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateInstructor(Instructor instructor);
    Course findCourseById(int id);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    void saveCourse(Course course);
    Course findCourseAndReviewsById(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void updateStudent(Student student);
}
