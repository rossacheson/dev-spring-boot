package com.rossacheson.rest_crud.rest;

import com.rossacheson.rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Mario", "Snow"));
        students.add(new Student("May", "Trow"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // pretend studentId is the index for now

        if(studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student with id " + studentId + " not found");
        }

        return students.get(studentId);
    }

}
