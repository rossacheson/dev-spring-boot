package com.rossacheson.cruddemo;

import com.rossacheson.cruddemo.dao.StudentDAO;
import com.rossacheson.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the Student object
		System.out.println("Creating student object...");
		Student newStudent = new Student("Paul", "Doe", "paul@test.com");

		// save
		System.out.println("Saving the Student...");
		studentDAO.save(newStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated ID: " + newStudent.getId());
	}

}
