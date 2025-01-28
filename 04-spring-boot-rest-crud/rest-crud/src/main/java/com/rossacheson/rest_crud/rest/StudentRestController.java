package com.rossacheson.rest_crud.rest;

import com.rossacheson.rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
