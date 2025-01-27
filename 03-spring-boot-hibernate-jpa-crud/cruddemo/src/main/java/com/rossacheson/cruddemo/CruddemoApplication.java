package com.rossacheson.cruddemo;

import com.rossacheson.cruddemo.dao.StudentDAO;
import com.rossacheson.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Daffy", "Duck", "daffy@test.com");
		studentDAO.save(student);

		int id = student.getId();
		System.out.println("Saved student. Generated ID: " + student.getId());

		System.out.println("Retrieving student with id: " + id);
		Student myStudent = studentDAO.findById(id);
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students...");
		Student student1 = new Student("John", "Doe", "john@test.com");
		Student student2 = new Student("Mary", "Public", "mary@test.com");
		Student student3 = new Student("Bonita", "Applebaum", "bonita@test.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
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
